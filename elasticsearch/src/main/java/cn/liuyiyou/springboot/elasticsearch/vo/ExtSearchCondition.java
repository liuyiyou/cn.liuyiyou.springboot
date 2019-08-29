package cn.liuyiyou.springboot.elasticsearch.vo;

import lombok.Data;
import lombok.experimental.Accessors;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;

import java.util.List;

/**
 * @author
 */
@Accessors(chain = true)
@Data
public class ExtSearchCondition {
    private Integer pageIndex;
    private Integer pageSize;
    private List<String> sortFieldList;
    private List<String> highLightFields;
    private List<TermsAggregationBuilder> termsAggregationBuilders;
}
