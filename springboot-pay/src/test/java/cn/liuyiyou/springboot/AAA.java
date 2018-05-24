package cn.liuyiyou.springboot;

import cn.liuyiyou.springboot.entity.PayType;

/***
 * @author: liuyiyou
 * @date: 2018/5/21
 */
public class AAA {

    public static void main(String[] args) {
        PayType payType = PayType.valueOf("WXPAY");
        System.out.println(payType.getCode());
    }
}
