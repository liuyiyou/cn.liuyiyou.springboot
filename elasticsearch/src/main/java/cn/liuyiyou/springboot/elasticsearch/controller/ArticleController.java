package cn.liuyiyou.springboot.elasticsearch.controller;

import cn.liuyiyou.springboot.elasticsearch.domain.Article;
import cn.liuyiyou.springboot.elasticsearch.service.IArticleService;
import cn.liuyiyou.springboot.elasticsearch.vo.ArticleQueryVo;
import io.searchbox.core.SearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: liuyiyou.cn
 * @date: 2019/8/26
 * @version: V1.0
 */
@RestController
public class ArticleController {

    @Autowired
    private IArticleService articleService;

    @GetMapping("/query")
    public List<Article> searchArticleByTitle(@RequestParam("q") String q) {
        final List<Article> articles = articleService.searchArticle(q);
        return articles;
    }

    @PostMapping("/query/jpa")
    public Page<Article> searchByKeyword(@RequestBody ArticleQueryVo articleQueryVo) {
        final Page<Article> articles = articleService.searchArticlePage(articleQueryVo);
        return articles;
    }

    @PostMapping("/query/jest")
    public SearchResult searchByKeywordJest(@RequestBody ArticleQueryVo articleQueryVo) {
        final SearchResult searchResult = articleService.searchArticleByJest(articleQueryVo);
        return searchResult;
    }
}
