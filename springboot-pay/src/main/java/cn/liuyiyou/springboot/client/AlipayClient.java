package cn.liuyiyou.springboot.client;

import cn.liuyiyou.springboot.entity.PayRequest;
import cn.liuyiyou.springboot.entity.PayResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/***
 * @author: liuyiyou
 * @date: 2018/5/21
 */
@Slf4j
@Service("alipayClient")
public class AlipayClient implements IPayClient {


    @Override
    public PayResult pay(PayRequest payRequest) {
        new AlipayClient();
        return alipay(payRequest);
    }


    public PayResult alipay(PayRequest payRequest) {
        log.info("使用支付宝支付");
        log.info(payRequest.toString());
        return PayResult.builder().code(1000).msg("SUCCESS").build();
    }
}
