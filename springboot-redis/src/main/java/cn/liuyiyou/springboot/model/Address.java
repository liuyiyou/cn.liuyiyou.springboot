package cn.liuyiyou.springboot.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: liuyiyou
 * @date: 2017/12/8
 * Time: 下午2:23
 */
@Data
public class Address implements Serializable {
    private String provice;
    private String city;
    private String street;
}
