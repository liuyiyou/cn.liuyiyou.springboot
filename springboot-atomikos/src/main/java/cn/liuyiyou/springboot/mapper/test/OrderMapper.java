package com.ibalife.message.mapper.test;

import com.ibalife.message.model.Order;
import org.springframework.stereotype.Repository;

/**
 * User: liuyiyou
 * Date: 2017/9/9
 * Time: 下午4:16
 */
@Repository //这个注解可以不要
public interface OrderMapper {

    void insert(Order order);
}
