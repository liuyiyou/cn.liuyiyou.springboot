package cn.liuyiyou.springboot.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author: liuyiyou.cn
 * @date: 2019/2/15
 * @version: V1.0
 */
@Data
@Accessors(chain = true)
public class Address {

    private String prov;
    private String city;
}
