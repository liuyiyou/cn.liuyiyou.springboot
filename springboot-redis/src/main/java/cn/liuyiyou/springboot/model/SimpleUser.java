package cn.liuyiyou.springboot.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: liuyiyou
 * @date: 2017/12/8
 * Time: 下午2:23
 */
@Data
public class SimpleUser implements Serializable {
    private int id;
    private String name;
}
