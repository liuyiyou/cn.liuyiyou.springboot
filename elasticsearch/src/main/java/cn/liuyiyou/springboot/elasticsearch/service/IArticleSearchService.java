package cn.liuyiyou.springboot.elasticsearch.service;

import cn.liuyiyou.springboot.elasticsearch.domain.ArticleSearch;
import cn.liuyiyou.springboot.elasticsearch.result.SearchEngineResult;
import cn.liuyiyou.springboot.elasticsearch.vo.ArticleQueryVo;

import java.util.List;

/**
 * @author: liuyiyou.cn
 * @date: 2019/8/26
 * @version: V1.0
 */

public interface IArticleSearchService {

    List<ArticleSearch> searchArticle(String title);



    SearchEngineResult searchArticleByJest(ArticleQueryVo articleQueryVo);

    boolean initArticleMapping();

    boolean initArticleData();

    List<ArticleSearch> search();

    List<ArticleSearch> searchArticlePage(ArticleQueryVo articleQueryVo);
}
