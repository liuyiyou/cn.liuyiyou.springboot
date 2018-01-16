package cn.liuyiyou.springboot.web;

import cn.liuyiyou.springboot.property.HomeProperties;
import cn.liuyiyou.springboot.property.MyProperties;
import cn.liuyiyou.springboot.property.UserProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Spring Boot HelloWorld 案例
 * <p>
 * Created by liuyiyou.cn on 16/4/26.
 */
@RestController
public class HelloWorldController {

    @Autowired
    HomeProperties homeProperties;
    @Autowired
    UserProperties userProperties;
    @Autowired
    MyProperties myProperties;

    @RequestMapping("/")
    public String sayHello() {
        System.out.println(homeProperties);
        System.out.println(userProperties);
        System.out.println(myProperties);
        return "Hello,World2!";
    }

    @RequestMapping("/properties")
    public String properties() {
        System.out.println(homeProperties);
        System.out.println(userProperties);
        System.out.println(myProperties);
        return "Hello,World2!";
    }



}
