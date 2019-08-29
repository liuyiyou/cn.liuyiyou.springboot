package cn.liuyiyou.springboot.elasticsearch.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author lzt
 * @date 2018.07.11
 */
@Data
@Accessors(chain = true)
public class ArticleQueryVo {
    private String keyWord;
    private List<String> sortFieldList;
    private int page;
    private int pageSize;
}
