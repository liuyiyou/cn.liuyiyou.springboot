package cn.liuyiyou.springboot.service;

import cn.liuyiyou.springboot.client.IPayClient;
import cn.liuyiyou.springboot.entity.PayRequest;
import cn.liuyiyou.springboot.entity.PayResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/***
 * @author: liuyiyou
 * @date: 2018/5/21
 */
@Service
public class PayService implements IPayService {


    @Autowired
    private final Map<String, IPayClient> strategyMap = new ConcurrentHashMap<>();


    @Override
    public PayResult pay(PayRequest payRequest) {
        return strategyMap.get(payRequest.getPayType().getClient()).pay(payRequest);
    }
}
