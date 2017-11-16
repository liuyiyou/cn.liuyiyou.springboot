package com.ibalife.message.mapper.iba;

import com.ibalife.message.model.UserDelivery;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * User: liuyiyou
 * Date: 2017/9/10
 * Time: 上午1:48
 */
@Repository
public interface UserDeliveryMapper {


    UserDelivery getUserDeliveryById(@Param("id") Long id);

    void insert(UserDelivery userDelivery);

}
