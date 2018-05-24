package cn.liuyiyou.springboot;

import cn.liuyiyou.springboot.entity.PayRequest;
import cn.liuyiyou.springboot.entity.PayType;
import cn.liuyiyou.springboot.service.IPayService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/***
 * @author: liuyiyou
 * @date: 2018/5/21
 */
public class PayServiceTest extends PayApplicationTests {

    @Autowired
    private IPayService payService;

    @Test
    public void pay(){
        payService.pay(PayRequest.builder().payType(PayType.WXPAY).amount(1.0).build());
        payService.pay(PayRequest.builder().payType(PayType.ALIPAY).amount(2.0).build());
    }

}
