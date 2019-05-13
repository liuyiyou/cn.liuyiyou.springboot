package cn.liuyiyou.springboot.config;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/***
 *
 * @author: liuyiyou.cn
 * @date: 2018/9/29
 * @Copyright 2018 liuyiyou.cn Inc. All rights reserved
 */
@Data
@Accessors(chain = true)
@Configuration
@ConfigurationProperties(prefix = "user")
public class UserConfig {

    private String name;
    private int age;
    private String prov;

}
