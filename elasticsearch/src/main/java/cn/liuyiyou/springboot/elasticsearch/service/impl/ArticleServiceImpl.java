package cn.liuyiyou.springboot.elasticsearch.service.impl;

import cn.liuyiyou.springboot.elasticsearch.constant.SearchArticleConstans;
import cn.liuyiyou.springboot.elasticsearch.domain.Article;
import cn.liuyiyou.springboot.elasticsearch.repository.ArticleRepository;
import cn.liuyiyou.springboot.elasticsearch.service.IArticleService;
import cn.liuyiyou.springboot.elasticsearch.vo.ArticleQueryVo;
import cn.liuyiyou.springboot.elasticsearch.vo.ExtSearchCondition;
import io.searchbox.client.JestClient;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static cn.liuyiyou.springboot.elasticsearch.constant.SearchArticleConstans.ARTICLE_FIELD_CONTENT;
import static cn.liuyiyou.springboot.elasticsearch.constant.SearchArticleConstans.ARTICLE_FIELD_CONTENT_FPY;
import static cn.liuyiyou.springboot.elasticsearch.constant.SearchArticleConstans.ARTICLE_FIELD_CONTENT_SPY;
import static cn.liuyiyou.springboot.elasticsearch.constant.SearchArticleConstans.ARTICLE_FIELD_SUMMARY;
import static cn.liuyiyou.springboot.elasticsearch.constant.SearchArticleConstans.ARTICLE_FIELD_SUMMARY_FPY;
import static cn.liuyiyou.springboot.elasticsearch.constant.SearchArticleConstans.ARTICLE_FIELD_SUMMARY_SPY;
import static cn.liuyiyou.springboot.elasticsearch.constant.SearchArticleConstans.ARTICLE_FIELD_TITLE;
import static cn.liuyiyou.springboot.elasticsearch.constant.SearchArticleConstans.ARTICLE_FIELD_TITLE_FPY;
import static cn.liuyiyou.springboot.elasticsearch.constant.SearchArticleConstans.ARTICLE_FIELD_TITLE_SPY;
import static cn.liuyiyou.springboot.elasticsearch.constant.SearchArticleConstans.ARTICLE_HIGHLIGHT_FIELDS;
import static cn.liuyiyou.springboot.elasticsearch.constant.SearchArticleConstans.SEARCH_ARTICLE_TYPE;
import static com.google.common.collect.Lists.newArrayList;
import static java.util.Arrays.asList;
import static java.util.Objects.nonNull;
import static java.util.Optional.ofNullable;
import static org.apache.commons.lang3.StringUtils.upperCase;
import static org.apache.logging.log4j.util.Strings.isNotEmpty;
import static org.elasticsearch.index.query.QueryBuilders.boolQuery;
import static org.elasticsearch.index.query.QueryBuilders.multiMatchQuery;

/**
 * @author: liuyiyou.cn
 * @date: 2019/8/26
 * @version: V1.0
 */
@Service
@Slf4j
public class ArticleServiceImpl implements IArticleService {

    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private JestClient jestClient;

    @Override
    public Page<Article> searchArticlePage(ArticleQueryVo articleQueryVo) {
        final Page<Article> articles = articleRepository.search(constructSearchArticleConditionQueryBuilder(articleQueryVo), PageRequest.of(articleQueryVo.getPage(), articleQueryVo.getPageSize()));
        return articles;
    }

    @Override
    public List<Article> searchArticle(String title) {
        final List<Article> articles = articleRepository.findByTitle(title);
        return articles;
    }

    @Override
    public SearchResult searchArticleByJest(ArticleQueryVo articleQueryVo) {
        return createSearch(SearchArticleConstans.ARTICLE_INDEX, new String[]{SEARCH_ARTICLE_TYPE}, constructSearchArticleConditionQueryBuilder(articleQueryVo), transferArticleQueryVoToExtSearchCondition(articleQueryVo));
    }

    public SearchResult createSearch(String index, String[] indexTypes, QueryBuilder queryBuilder, ExtSearchCondition extSearchCondition) {
        SearchResult result = null;
        try {
            SearchSourceBuilder searchSourceBuilder =
                    constructSearchSourceBuilderExtCondition(extSearchCondition, new SearchSourceBuilder().query(queryBuilder));
            result = jestClient.execute(new Search.Builder(searchSourceBuilder.toString()).addIndex(index)
                    .addTypes(asList(indexTypes))
                    .build());
        } catch (IOException e) {
            log.error("搜索结果报错", e);
        }
        log.info(result.toString());
        return result;
    }

    public SearchSourceBuilder constructSearchSourceBuilderExtCondition(ExtSearchCondition extSearchCondition, SearchSourceBuilder query) {
        SearchSourceBuilder searchSourceBuilder = query
                .from(nonNull(extSearchCondition.getPageIndex()) ? extSearchCondition.getPageIndex() : 0)
                .size(nonNull(extSearchCondition.getPageSize()) ? extSearchCondition.getPageSize() : 0);
        if (isNotEmpty((CharSequence) extSearchCondition.getHighLightFields())) {
            searchSourceBuilder.highlighter(configHighLightBuilder(extSearchCondition.getHighLightFields()));
        }
        ofNullable(extSearchCondition.getSortFieldList()).ifPresent(list -> list.forEach(s -> {
            String[] attrs = s.split("\\|");
            if (attrs.length == 2) {
                searchSourceBuilder.sort(attrs[0], SortOrder.valueOf(upperCase(attrs[1])));
            }
        }));
        ofNullable(extSearchCondition.getTermsAggregationBuilders()).ifPresent(termsAggregationBuilders -> termsAggregationBuilders
                .forEach(searchSourceBuilder::aggregation));
        return searchSourceBuilder;
    }

    public ExtSearchCondition transferArticleQueryVoToExtSearchCondition(ArticleQueryVo articleQueryVo) {
        return new ExtSearchCondition()
                .setHighLightFields(asList(getQueryFieldsByKeyWord(articleQueryVo.getKeyWord(), ARTICLE_HIGHLIGHT_FIELDS)))
                .setSortFieldList(articleQueryVo.getSortFieldList())
                .setPageIndex(articleQueryVo.getPage())
                .setPageSize(articleQueryVo.getPageSize());
    }

    private HighlightBuilder configHighLightBuilder(List<String> fields) {
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.preTags("<font color='#C11C1C'>").postTags("</font>").fragmentSize(200);
        ofNullable(fields).ifPresent(fieldList -> fieldList.forEach(highlightBuilder::field));
        return highlightBuilder;
    }


    public BoolQueryBuilder constructSearchArticleConditionQueryBuilder(ArticleQueryVo articleQueryVo) {
        BoolQueryBuilder boolQueryBuilder = boolQuery();
        List<BoolQueryBuilder> boolQueryBuilderList = newArrayList();
        BoolQueryBuilder keywordBuilder = boolQuery();
        keywordBuilder
                .must(multiMatchQuery(articleQueryVo.getKeyWord(), getQueryFieldsByKeyWord(articleQueryVo.getKeyWord(), asList(ARTICLE_FIELD_TITLE, ARTICLE_FIELD_SUMMARY, ARTICLE_FIELD_CONTENT))).minimumShouldMatch("100%"));
        boolQueryBuilderList.add(keywordBuilder);
        boolQueryBuilder.should().addAll(boolQueryBuilderList);
        log.info(boolQueryBuilder.toString());
        return boolQueryBuilder;
    }

    private String[] getQueryFieldsByKeyWord(String keyWord, List<String> queryFields) {
        String regex = ".*[a-zA-z].*";
        ArrayList<String> fileds = new ArrayList<>();
        fileds.addAll(queryFields);
        if (isNotEmpty(keyWord) && keyWord.matches(regex)) {
            fileds.add(ARTICLE_FIELD_TITLE_FPY);
            fileds.add(ARTICLE_FIELD_TITLE_SPY);
            fileds.add(ARTICLE_FIELD_SUMMARY_FPY);
            fileds.add(ARTICLE_FIELD_SUMMARY_SPY);
            fileds.add(ARTICLE_FIELD_CONTENT_FPY);
            fileds.add(ARTICLE_FIELD_CONTENT_SPY);
        }
        return fileds.toArray(new String[queryFields.size()]);
    }
}
