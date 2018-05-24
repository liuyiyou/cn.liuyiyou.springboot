package cn.liuyiyou.springboot.client;

import cn.liuyiyou.springboot.entity.PayRequest;
import cn.liuyiyou.springboot.entity.PayResult;

/***
 * @author: liuyiyou
 * @date: 2018/5/21
 */
public interface IPayClient {


    PayResult pay(PayRequest payRequest);
}
