package cn.liuyiyou.springboot.elasticsearch.service;

import cn.liuyiyou.springboot.elasticsearch.domain.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * @author: liuyiyou.cn
 * @date: 2019/8/30
 * @version: V1.0
 */
public interface IArticleService {
    Article findById(Long id);

    Page<Article> findAll(PageRequest pageRequest);
}
