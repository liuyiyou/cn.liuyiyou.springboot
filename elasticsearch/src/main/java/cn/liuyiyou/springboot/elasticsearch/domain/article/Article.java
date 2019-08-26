/*
 * file comment: Article.java
 * Copyright(C) All rights reserved.
 */
package cn.liuyiyou.springboot.elasticsearch.domain.article;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

@Data
@Builder
@Document(indexName = "article_index", type = "search_article_type", shards = 1, replicas = 0,
        refreshInterval = "-1")
@NoArgsConstructor
@AllArgsConstructor
public class Article implements Serializable {

    private Long id;
    private String title;
    private String summary;
    private String content;
    private String thumbnailPics;
    private String statusTime;

}
