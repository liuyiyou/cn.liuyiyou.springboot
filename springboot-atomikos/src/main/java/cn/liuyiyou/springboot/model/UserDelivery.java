package cn.liuyiyou.springboot.model;

/**
 * User: liuyiyou
 * Date: 2017/9/10
 * Time: 上午1:49
 */
public class UserDelivery {

    private Long id;
    private String consignee;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }
}
