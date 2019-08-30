package cn.liuyiyou.springboot.elasticsearch.service.impl;

import cn.liuyiyou.springboot.elasticsearch.domain.Article;
import cn.liuyiyou.springboot.elasticsearch.repository.ArticleRepository;
import cn.liuyiyou.springboot.elasticsearch.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * @author: liuyiyou.cn
 * @date: 2019/8/30
 * @version: V1.0
 */
@Service
public class ArticleServiceImpl implements IArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public Article findById(Long id) {
        return articleRepository.findById(id).orElse(new Article());
    }

    @Override
    public Page<Article> findAll(PageRequest pageRequest) {
        return articleRepository.findAll(pageRequest);
    }
}
