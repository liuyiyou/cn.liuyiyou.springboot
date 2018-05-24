package cn.liuyiyou.springboot.model;

import java.io.Serializable;

/**
 * @author: liuyiyou
 * @date: 2017/12/8
 * Time: 下午2:23
 */
public class Address implements Serializable {

    private String provice;
    private String city;
    private String street;

    public String getProvice() {
        return provice;
    }

    public void setProvice(String provice) {
        this.provice = provice;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
