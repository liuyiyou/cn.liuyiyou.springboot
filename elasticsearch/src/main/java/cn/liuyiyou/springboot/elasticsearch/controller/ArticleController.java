package cn.liuyiyou.springboot.elasticsearch.controller;

import cn.liuyiyou.springboot.elasticsearch.domain.Article;
import cn.liuyiyou.springboot.elasticsearch.repository.ArticleRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: liuyiyou.cn
 * @date: 2019/8/26
 * @version: V1.0
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;


    @GetMapping("/get/{id}")
    public Article get(@PathVariable Long id) {
        return articleRepository.findById(id).orElse(null);
    }


    @GetMapping("/page")
    public Page<Article> page(
            @RequestParam(value = "q", required = false) String q, Pageable pageable) {
        if (StringUtils.isNoneEmpty(q)) {
            ExampleMatcher matcher = ExampleMatcher.matching() //构建对象
                    .withMatcher("title", ExampleMatcher.GenericPropertyMatchers.startsWith());//姓名采用“开始匹配”的方式查询
            Article article = new Article();
            article.setTitle(q);
            Example<Article> example = Example.of(article, matcher);
            return articleRepository.findAll(example, pageable);
        } else {
            return articleRepository.findAll(pageable);
        }


    }

}
