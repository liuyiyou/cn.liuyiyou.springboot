package cn.liuyiyou.springboot.autoconfigure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @author: liuyiyou.cn
 * @date: 2019/11/28
 * @version: V1.0
 */
@Configuration
@EnableConfigurationProperties(LyyProperties.class)
public class LyyAutoConfiguration {

    @Autowired
    private LyyProperties hornetQProperties;

    @PostConstruct
    public void sys(){
        System.out.println(hornetQProperties.getName());
        System.out.println(hornetQProperties.getAge());
    }
}
