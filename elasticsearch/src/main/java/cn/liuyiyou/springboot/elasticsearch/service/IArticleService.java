package cn.liuyiyou.springboot.elasticsearch.service;

import cn.liuyiyou.springboot.elasticsearch.domain.Article;
import cn.liuyiyou.springboot.elasticsearch.vo.ArticleQueryVo;
import io.searchbox.core.SearchResult;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author: liuyiyou.cn
 * @date: 2019/8/26
 * @version: V1.0
 */

public interface IArticleService {

    List<Article> searchArticle(String title);

    Page<Article> searchArticlePage(ArticleQueryVo articleQueryVo);

    SearchResult searchArticleByJest(ArticleQueryVo articleQueryVo);

}
