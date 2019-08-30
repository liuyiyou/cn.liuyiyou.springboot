/*
 * file comment: Article.java
 * Copyright(C) All rights reserved.
 */
package cn.liuyiyou.springboot.elasticsearch.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Mapping;
import org.springframework.data.elasticsearch.annotations.Setting;

import javax.persistence.Id;
import java.io.Serializable;

@Data
@Builder
@Document(indexName = "article_index", type = "search_article_type")
@Mapping(mappingPath = "articlesearch_mapping.json")
@Setting(settingPath = "common_index_setting.json")
@NoArgsConstructor
@AllArgsConstructor
public class ArticleSearch implements Serializable, Cloneable {

    @Id
    private Long id;
    private String title;
    private String summary;
    private String content;
    private String thumbnailPics;
    private String statusTime;

    @Override
    public ArticleSearch clone() {
        return new ArticleSearch();
    }
}
