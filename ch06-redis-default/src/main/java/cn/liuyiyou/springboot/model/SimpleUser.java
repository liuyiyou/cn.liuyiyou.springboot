package cn.liuyiyou.springboot.model;

import java.io.Serializable;

/**
 * @author: liuyiyou
 * @date: 2017/12/8
 * Time: 下午2:23
 */
public class SimpleUser implements Serializable{

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
