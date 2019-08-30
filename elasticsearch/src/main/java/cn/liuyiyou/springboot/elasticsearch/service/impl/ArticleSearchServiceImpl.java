package cn.liuyiyou.springboot.elasticsearch.service.impl;

import cn.liuyiyou.springboot.elasticsearch.constant.SearchArticleConstans;
import cn.liuyiyou.springboot.elasticsearch.domain.ArticleSearch;
import cn.liuyiyou.springboot.elasticsearch.repository.ArticleRepository;
import cn.liuyiyou.springboot.elasticsearch.repository.ArticleSearchRepository;
import cn.liuyiyou.springboot.elasticsearch.result.SearchEngineResult;
import cn.liuyiyou.springboot.elasticsearch.service.IArticleSearchService;
import cn.liuyiyou.springboot.elasticsearch.service.SearchUtil;
import cn.liuyiyou.springboot.elasticsearch.vo.ArticleQueryVo;
import io.searchbox.client.JestClient;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static cn.liuyiyou.springboot.elasticsearch.constant.SearchArticleConstans.ARTICLE_FIELD_CONTENT;
import static cn.liuyiyou.springboot.elasticsearch.constant.SearchArticleConstans.ARTICLE_FIELD_SUMMARY;
import static cn.liuyiyou.springboot.elasticsearch.constant.SearchArticleConstans.ARTICLE_FIELD_TITLE;
import static cn.liuyiyou.springboot.elasticsearch.constant.SearchArticleConstans.SEARCH_ARTICLE_TYPE;
import static cn.liuyiyou.springboot.elasticsearch.service.SearchUtil.constructSearchArticleConditionQueryBuilder;
import static cn.liuyiyou.springboot.elasticsearch.service.SearchUtil.transferArticleQueryVoToExtSearchCondition;
import static org.elasticsearch.index.query.QueryBuilders.boolQuery;
import static org.elasticsearch.index.query.QueryBuilders.multiMatchQuery;

/**
 * @author: liuyiyou.cn
 * @date: 2019/8/26
 * @version: V1.0
 */
@Service
@Slf4j
public class ArticleSearchServiceImpl implements IArticleSearchService {

    @Autowired
    private ArticleSearchRepository articleSearchRepository;
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private JestClient jestClient;
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Override
    public List<ArticleSearch> searchArticle(String title) {
        return articleSearchRepository.findByTitle(title);
    }

    @Override
    public boolean initArticleMapping() {
        elasticsearchTemplate.deleteIndex(ArticleSearch.class);
        elasticsearchTemplate.createIndex(ArticleSearch.class);
        elasticsearchTemplate.putMapping(ArticleSearch.class);
        return true;
    }

    @Override
    public boolean initArticleData() {
        List<IndexQuery> indexQueries = new ArrayList<>();
        articleRepository.findAll().forEach(article -> {
            final ArticleSearch articleSearch = new ArticleSearch();
            BeanUtils.copyProperties(article, articleSearch);
            IndexQuery indexQuery = new IndexQueryBuilder().withId(articleSearch.getId().toString()).withObject(articleSearch).build();
            indexQueries.add(indexQuery);
        });
        elasticsearchTemplate.bulkIndex(indexQueries);
        return true;
    }

    @Override
    public List<ArticleSearch> search() {
        BoolQueryBuilder keywordBuilder = boolQuery();
        keywordBuilder
                .must(multiMatchQuery("测试文章", ARTICLE_FIELD_TITLE)//, ARTICLE_FIELD_SUMMARY, ARTICLE_FIELD_CONTENT)
                ).minimumShouldMatch("100%");
        NativeSearchQuery query = new NativeSearchQuery(keywordBuilder);
        return elasticsearchTemplate.queryForList(query, ArticleSearch.class);
    }

    //    @Autowired
//    private ElasticsearchTemplate template;

    @Override
    public Page<ArticleSearch> searchArticlePage(ArticleQueryVo articleQueryVo) {
//        final BoolQueryBuilder builder = constructSearchArticleConditionQueryBuilder(articleQueryVo);
        final QueryStringQueryBuilder builder = QueryBuilders.queryStringQuery(articleQueryVo.getKeyWord());
        final BoolQueryBuilder should = QueryBuilders.boolQuery().must(builder).minimumShouldMatch(100);
        log.info(should.toString());
        final Page<ArticleSearch> articles = articleSearchRepository.search(should, PageRequest.of(articleQueryVo.getPage(), articleQueryVo.getPageSize()));
//        final Page<Article> articles = articleSearchRepository.findByJpa(articleQueryVo.getKeyWord(), PageRequest.of(articleQueryVo.getPage(), articleQueryVo.getPageSize()));
        return articles;
    }


    @Override
    public SearchEngineResult searchArticleByJest(ArticleQueryVo articleQueryVo) {
        return SearchUtil.createSearch(jestClient, SearchArticleConstans.ARTICLE_INDEX, new String[]{SEARCH_ARTICLE_TYPE},
                constructSearchArticleConditionQueryBuilder(articleQueryVo),
                transferArticleQueryVoToExtSearchCondition(articleQueryVo));
    }


}
