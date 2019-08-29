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

import java.io.Serializable;

@Data
@Builder
@Document(indexName = "article_index", type = "search_article_type")
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
