package cn.liuyiyou.springboot.model;

import org.springframework.http.converter.json.Jackson2ObjectMapperFactoryBean;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

/**
 * @author: liuyiyou
 * @date: 2017/12/20
 * Time: 上午10:21
 */
public class User {


    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    private Date birthDay;
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        System.out.println("getName");
        return name;
    }

    public void setName(String name) {
        System.out.println("setName");
        this.name = name;
    }


    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }
}
