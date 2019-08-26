package cn.liuyiyou.springboot.elasticsearch.repository;

import cn.liuyiyou.springboot.elasticsearch.domain.article.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author: liuyiyou.cn
 * @date: 2019/8/26
 * @version: V1.0
 */
public interface ArticleRepository extends ElasticsearchRepository<Article, Long> {


    List<Article> findByTitle(String title);
}
