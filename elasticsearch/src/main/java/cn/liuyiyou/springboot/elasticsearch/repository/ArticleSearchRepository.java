package cn.liuyiyou.springboot.elasticsearch.repository;

import cn.liuyiyou.springboot.elasticsearch.domain.ArticleSearch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @author: liuyiyou.cn
 * @date: 2019/8/26
 * @version: V1.0
 */
public interface ArticleSearchRepository extends ElasticsearchRepository<ArticleSearch, Long> {


    List<ArticleSearch> findByTitle(String title);

    @Query("{\n" +
            "  \"bool\" : {\n" +
            "    \"should\" : [\n" +
            "      {\n" +
            "        \"bool\" : {\n" +
            "          \"must\" : [\n" +
            "            {\n" +
            "              \"multi_match\" : {\n" +
            "                \"query\" : \"测试\",\n" +
            "                \"fields\" : [\n" +
            "                  \"content^1.0\",\n" +
            "                  \"summary^1.0\",\n" +
            "                  \"title^1.0\"\n" +
            "                ],\n" +
            "                \"type\" : \"best_fields\",\n" +
            "                \"operator\" : \"OR\",\n" +
            "                \"slop\" : 0,\n" +
            "                \"prefix_length\" : 0,\n" +
            "                \"max_expansions\" : 50,\n" +
            "                \"minimum_should_match\" : \"100%\",\n" +
            "                \"lenient\" : false,\n" +
            "                \"zero_terms_query\" : \"NONE\",\n" +
            "                \"boost\" : 1.0\n" +
            "              }\n" +
            "            }\n" +
            "          ],\n" +
            "          \"disable_coord\" : false,\n" +
            "          \"adjust_pure_negative\" : true,\n" +
            "          \"boost\" : 1.0\n" +
            "        }\n" +
            "      }\n" +
            "    ],\n" +
            "    \"disable_coord\" : false,\n" +
            "    \"adjust_pure_negative\" : true,\n" +
            "    \"boost\" : 1.0\n" +
            "  }\n" +
            "}")
    Page<ArticleSearch> findByJpa(String keyword, Pageable pageable);
}
