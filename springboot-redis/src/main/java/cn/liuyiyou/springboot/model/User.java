package cn.liuyiyou.springboot.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author: liuyiyou
 * @date: 2017/12/8
 * Time: 下午2:21
 */
@Data
public class User implements Serializable {

    private Integer aInteger;
    private Float aFloat;
    private Double aDouble;
    private Date date;
    private Boolean aBoolean;
    private String string;
    private Map<String, String> map;
    private List<Integer> list;
    private Set<String> set;
    private Address address;

}
