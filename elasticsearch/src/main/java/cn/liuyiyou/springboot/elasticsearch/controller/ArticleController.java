package cn.liuyiyou.springboot.elasticsearch.controller;

import cn.liuyiyou.springboot.elasticsearch.domain.article.Article;
import cn.liuyiyou.springboot.elasticsearch.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
    public List<Article> searchArticle(@RequestParam("q") String q) {
        final List<Article> articles = articleService.searchArticle(q);
        return articles;
    }
}
