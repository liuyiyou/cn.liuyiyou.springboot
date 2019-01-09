package cn.liuyiyou.springboot;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author: liuyiyou.cn
 * @date: 2018/12/29
 * @version: V1.0
 */
@Data
@Accessors(chain = true)
public class User {

    @JSONField(serializeUsing = OssPathSerializer.class)
    private String path;

    private int _int;
    private Integer _integer;
    private boolean _boolean;
    private Boolean _Boolean;

    private String _string;
    private long _long;
    private List<String> _list;
    private Set<String> _set;
    private Map<String, String> _map = new HashMap<>();
    private Address address;

    private Date date;
}
