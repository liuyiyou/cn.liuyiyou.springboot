package cn.liuyiyou.springboot.elasticsearch.controller;

import cn.liuyiyou.springboot.elasticsearch.domain.Article;
import cn.liuyiyou.springboot.elasticsearch.domain.ArticleSearch;
import cn.liuyiyou.springboot.elasticsearch.result.SearchEngineResult;
import cn.liuyiyou.springboot.elasticsearch.service.IArticleSearchService;
import cn.liuyiyou.springboot.elasticsearch.service.IArticleService;
import cn.liuyiyou.springboot.elasticsearch.vo.ArticleQueryVo;
import cn.liuyiyou.springboot.elasticsearch.vo.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: liuyiyou.cn
 * @date: 2019/8/26
 * @version: V1.0
 */
@RestController
@RequestMapping("/search/article")
public class ArticleSearchController {

    @Autowired
    private IArticleSearchService articleSearchService;


    @Autowired
    private IArticleService articleService;


    @GetMapping("/{id}")
    public Article getById(@PathVariable Long id) {
        return articleService.findById(id);
    }


    @GetMapping("/init/mapping")
    public Response initProdMapping() {
        return Response.ok(articleSearchService.initArticleMapping());
    }

    @PostMapping("/init/data")
    public Response initProdData() {
        return Response.ok(articleSearchService.initArticleData());
    }


    @GetMapping("/query")
    public List<ArticleSearch> searchArticleByTitle(@RequestParam("q") String q) {
        final List<ArticleSearch> articles = articleSearchService.searchArticle(q);
        return articles;
    }

    @GetMapping("/all")
    public List<ArticleSearch> all() {
        return articleSearchService.search();
    }

    @PostMapping("/query/jpa")
    public Page<ArticleSearch> searchByKeyword(@RequestBody ArticleQueryVo articleQueryVo) {
        final Page<ArticleSearch> articles = articleSearchService.searchArticlePage(articleQueryVo);
        return articles;
    }

    @PostMapping("/query/jest")
    public SearchEngineResult searchByKeywordJest(@RequestBody ArticleQueryVo articleQueryVo) {
        final SearchEngineResult searchResult = articleSearchService.searchArticleByJest(articleQueryVo);
        return searchResult;
    }
}
