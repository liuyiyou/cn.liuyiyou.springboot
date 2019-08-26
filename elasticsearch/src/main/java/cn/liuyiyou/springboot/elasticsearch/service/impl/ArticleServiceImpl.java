package cn.liuyiyou.springboot.elasticsearch.service.impl;

import cn.liuyiyou.springboot.elasticsearch.domain.article.Article;
import cn.liuyiyou.springboot.elasticsearch.repository.ArticleRepository;
import cn.liuyiyou.springboot.elasticsearch.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: liuyiyou.cn
 * @date: 2019/8/26
 * @version: V1.0
 */
@Service
public class ArticleServiceImpl implements IArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public List<Article> searchArticle(String title) {
        final List<Article> articles = articleRepository.findByTitle(title);
        return articles;
    }
}
