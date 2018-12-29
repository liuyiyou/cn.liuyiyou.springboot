package cn.liuyiyou.springboot.entity;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author: liuyiyou.cn
 * @date: 2018/12/28
 * @version: V1.0
 */
@Data
public class User {

    @Min(value = 0,message = "Id只能为整数")
    private Integer id;
    @NotNull(message = "用户名不能为空")
    private String name;
    @NotNull(message = "地址不能为空")
    private String address;
}
