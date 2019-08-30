package cn.liuyiyou.springboot.elasticsearch.repository;

import cn.liuyiyou.springboot.elasticsearch.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: liuyiyou.cn
 * @date: 2019/8/30
 * @version: V1.0
 */
@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {


}
