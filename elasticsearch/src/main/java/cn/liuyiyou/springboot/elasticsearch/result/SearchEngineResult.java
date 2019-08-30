package cn.liuyiyou.springboot.elasticsearch.result;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author lzt
 * @date 2018.06.22
 */
@Data
@Accessors(chain = true)
public class SearchEngineResult<T> implements Serializable{
 
	private static final long serialVersionUID = 4919428034386736595L;
	private Long total;
	private List<T> data;
	private Map<String, List<String>> aggregations;
}
