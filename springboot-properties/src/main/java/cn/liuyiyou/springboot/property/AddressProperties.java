package cn.liuyiyou.springboot.property;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/***
 * @author: liuyiyou
 * @date: 2018/3/17
 */
@Component
public class AddressProperties {

    @Value("${prov}")
    private String prov;
    @Value("{city}")
    private String city;

    public String getProv() {
        return prov;
    }

    public void setProv(String prov) {
        this.prov = prov;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
