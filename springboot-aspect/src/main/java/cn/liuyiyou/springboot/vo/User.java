package cn.liuyiyou.springboot.vo;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.validation.constraints.NotNull;

/**
 * @author: liuyiyou
 * @date: 2017/12/18
 * Time: 下午10:44
 */
public class User {

    @PostConstruct
    public void init(){
        System.out.println("init");
    }

    @NotNull
    private Integer id;

    public String name;

    private String hobby;

    public Integer getId() {
        return id;
    }


    @EmptyElementFilter("yy")
    public void setId(Integer id) {
        this.id = id;
    }


    @EmptyElementFilter("xx")
    public String getName() {
        return name;
    }

    @EmptyElementFilter("zz")
    public void setName(String name) {
        this.name = name;
    }

    @EmptyElementFilter("getHobby")
    public String getHobby() {
        System.out.println("getHobby");
        return hobby;
    }

    @EmptyElementFilter("setHobby")
    public void setHobby(String hobby) {
        System.out.println("setHobby");
        this.hobby = hobby;
    }


    public void setAbc(){
        System.out.println("xxxx");
    }
}
