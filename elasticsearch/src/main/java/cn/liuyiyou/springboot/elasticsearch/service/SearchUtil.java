package cn.liuyiyou.springboot.elasticsearch.service;

import cn.liuyiyou.springboot.elasticsearch.domain.ArticleSearch;
import cn.liuyiyou.springboot.elasticsearch.result.SearchEngineResult;
import cn.liuyiyou.springboot.elasticsearch.vo.ArticleQueryVo;
import cn.liuyiyou.springboot.elasticsearch.vo.ExtSearchCondition;
import io.searchbox.client.JestClient;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.SortOrder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
import static com.google.common.collect.Lists.newArrayList;
import static java.util.Arrays.asList;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static java.util.Optional.ofNullable;
import static org.apache.commons.collections4.CollectionUtils.isNotEmpty;
import static org.apache.commons.lang3.StringUtils.isNoneEmpty;
import static org.apache.commons.lang3.StringUtils.upperCase;
import static org.elasticsearch.index.query.QueryBuilders.boolQuery;
import static org.elasticsearch.index.query.QueryBuilders.multiMatchQuery;
import static org.springframework.util.CollectionUtils.isEmpty;

/**
 * @author: liuyiyou.cn
 * @date: 2019/8/30
 * @version: V1.0
 */
@Slf4j
public class SearchUtil {

    public static SearchEngineResult createSearch(JestClient jestClient, String index, String[] indexTypes, QueryBuilder queryBuilder, ExtSearchCondition extSearchCondition) {
        SearchEngineResult searchEngineResult = null;
        try {
            SearchSourceBuilder searchSourceBuilder =
                    constructSearchSourceBuilderExtCondition(extSearchCondition, new SearchSourceBuilder().query(queryBuilder));
            SearchResult result = jestClient.execute(new Search.Builder(searchSourceBuilder.toString()).addIndex(index)
                    .addTypes(asList(indexTypes))
                    .build());
            searchEngineResult = constructArticleSearchResult(result);
        } catch (IOException e) {
            log.error("搜索结果报错", e);
        }
        return searchEngineResult;
    }

    private static SearchEngineResult constructArticleSearchResult(SearchResult searchResult) {
        SearchEngineResult searchEngineResult = new SearchEngineResult();
        if (isNull(searchResult)) {
            return searchEngineResult;
        }
        List<ArticleSearch> searchArticleList = newArrayList();
        ofNullable(searchResult.getHits(ArticleSearch.class)).ifPresent(list -> {
            list.forEach(h -> {
                ArticleSearch source = h.source;
                ofNullable(h.highlight).ifPresent(stringListMap -> {
                    fillTitleHighLight(source, stringListMap);
                    fillSummaryHighLight(source, stringListMap);
                });
                searchArticleList.add(source);
            });
        });
        searchEngineResult
                .setData(searchArticleList)
                .setTotal(searchResult.getTotal());
        return searchEngineResult;
    }

    private static void fillSummaryHighLight(ArticleSearch source, Map<String, List<String>> stringListMap) {
        List<String> summaryHighLightList = stringListMap.get(ARTICLE_FIELD_SUMMARY);
        List<String> summarySPYHighLightList = stringListMap.get(ARTICLE_FIELD_SUMMARY_SPY);
        List<String> summaryFPYHighLightList = stringListMap.get(ARTICLE_FIELD_SUMMARY_FPY);
        if (isNotEmpty(summaryHighLightList)) {
            source.setSummary(summaryHighLightList.get(0));
        } else if (isEmpty(summaryHighLightList) && isNotEmpty(summaryFPYHighLightList)) {
            source.setSummary(summaryFPYHighLightList.get(0));
        } else if (isEmpty(summaryHighLightList) && isNotEmpty(summarySPYHighLightList)) {
            source.setSummary(summarySPYHighLightList.get(0));
        }
    }

    private static void fillTitleHighLight(ArticleSearch source, Map<String, List<String>> stringListMap) {
        List<String> titleHighLightList = stringListMap.get(ARTICLE_FIELD_TITLE);
        List<String> titleSPYHighLightList = stringListMap.get(ARTICLE_FIELD_TITLE_SPY);
        List<String> titleFPYHighLightList = stringListMap.get(ARTICLE_FIELD_TITLE_FPY);
        if (isNotEmpty(titleHighLightList)) {
            source.setTitle(titleHighLightList.get(0));
        } else if (isEmpty(titleHighLightList) && isNotEmpty(titleFPYHighLightList)) {
            source.setTitle(titleFPYHighLightList.get(0));
        } else if (isEmpty(titleHighLightList) && isNotEmpty(titleSPYHighLightList)) {
            source.setTitle(titleSPYHighLightList.get(0));
        }
    }


    public static SearchSourceBuilder constructSearchSourceBuilderExtCondition(ExtSearchCondition extSearchCondition, SearchSourceBuilder query) {
        SearchSourceBuilder searchSourceBuilder = query
                .from(nonNull(extSearchCondition.getPageIndex()) ? extSearchCondition.getPageIndex() : 0)
                .size(nonNull(extSearchCondition.getPageSize()) ? extSearchCondition.getPageSize() : 0);
        if (isNotEmpty(extSearchCondition.getHighLightFields())) {
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

    public static ExtSearchCondition transferArticleQueryVoToExtSearchCondition(ArticleQueryVo articleQueryVo) {
        return new ExtSearchCondition()
                .setHighLightFields(asList(getQueryFieldsByKeyWord(articleQueryVo.getKeyWord(), ARTICLE_HIGHLIGHT_FIELDS)))
                .setSortFieldList(articleQueryVo.getSortFieldList())
                .setPageIndex(articleQueryVo.getPage())
                .setPageSize(articleQueryVo.getPageSize());
    }

    private static HighlightBuilder configHighLightBuilder(List<String> fields) {
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.preTags("<font color='#C11C1C'>").postTags("</font>").fragmentSize(200);
        ofNullable(fields).ifPresent(fieldList -> fieldList.forEach(highlightBuilder::field));
        return highlightBuilder;
    }


    public static BoolQueryBuilder constructSearchArticleConditionQueryBuilder(ArticleQueryVo articleQueryVo) {
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        List<BoolQueryBuilder> boolQueryBuilderList = newArrayList();
        BoolQueryBuilder keywordBuilder = boolQuery();
        keywordBuilder
                .must(multiMatchQuery(articleQueryVo.getKeyWord(), getQueryFieldsByKeyWord(articleQueryVo.getKeyWord(), asList(ARTICLE_FIELD_TITLE, ARTICLE_FIELD_SUMMARY, ARTICLE_FIELD_CONTENT))).minimumShouldMatch("100%"));
        boolQueryBuilderList.add(keywordBuilder);
        boolQueryBuilder.should().addAll(boolQueryBuilderList);
        log.info(boolQueryBuilder.toString());
        return boolQueryBuilder;
    }

    private static String[] getQueryFieldsByKeyWord(String keyWord, List<String> queryFields) {
        String regex = ".*[a-zA-z].*";
        ArrayList<String> fileds = new ArrayList<>();
        fileds.addAll(queryFields);
        if (isNoneEmpty(keyWord) && keyWord.matches(regex)) {
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
