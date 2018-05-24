package cn.liuyiyou.springboot.service;

import cn.liuyiyou.springboot.entity.PayRequest;
import cn.liuyiyou.springboot.entity.PayResult;

/***
 * @author: liuyiyou
 * @date: 2018/5/21
 */
public interface IPayService {


    PayResult pay(PayRequest payRequest);
}
