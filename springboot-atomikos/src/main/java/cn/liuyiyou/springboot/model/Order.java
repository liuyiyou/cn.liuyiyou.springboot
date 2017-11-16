package com.ibalife.message.model;

import java.io.Serializable;

/**
 * User: liuyiyou
 * Date: 2017/9/9
 * Time: 下午4:14
 */
public class Order implements Serializable{

    private int id;
    private int workerId;
    private String orderName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWorkerId() {
        return workerId;
    }

    public void setWorkerId(int workerId) {
        this.workerId = workerId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", workerId=" + workerId +
                ", orderName='" + orderName + '\'' +
                '}';
    }
}
