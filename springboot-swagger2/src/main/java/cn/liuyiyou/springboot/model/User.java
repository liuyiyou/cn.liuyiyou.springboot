package cn.liuyiyou.springboot.model;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

    private long id;
    private int age;
    private String name;

}
