package cn.liuyiyou.springboot.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author: liuyiyou.cn
 * @date: 2019/3/15
 * @version: V1.0
 */
@Data
@Accessors(chain = true)
public class User {

    private Integer id;
    private String name;
}
