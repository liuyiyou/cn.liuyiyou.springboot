package cn.liuyiyou.springboot.config;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author: liuyiyou.cn
 * @date: 2019/2/11
 * @version: V1.0
 */
@Data
@Accessors(chain = true)
@Configuration
@ConfigurationProperties(prefix = "address")
public class AddressConfig {

    private String prov;
    private String city;
    private String county;
}
