package cn.liuyiyou.springboot.entity;

/***
 * @author: liuyiyou
 * @date: 2018/5/21
 */
public enum PayType {

    ALIPAY(1, "alipayClient", "支付宝支付"),
    WXPAY(2, "wxpayClient", "微信支付");

    PayType(int code, String client, String desc) {
        this.code = code;
        this.client = client;
        this.desc = desc;
    }

    private int code;
    private String client;
    private String desc;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
