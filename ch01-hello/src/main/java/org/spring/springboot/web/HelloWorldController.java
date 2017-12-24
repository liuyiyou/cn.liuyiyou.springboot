package org.spring.springboot.web;

import org.assertj.core.util.Lists;
import org.spring.springboot.model.User;
import org.springframework.http.converter.json.Jackson2ObjectMapperFactoryBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Spring Boot HelloWorld 案例
 * <p>
 * Created by liuyiyou.cn on 17/09/27.
 */
@RestController
public class HelloWorldController {

    @RequestMapping("/")
    public String sayHello() {
        return "Hello,World!";
    }


    @RequestMapping("/user")
    public User getUser() {
        return new User() {{
            setName("中文");
            setId(1);
        }};
    }


    @RequestMapping("/userlist")
    public List<User> getUserList() {
        return userList();
    }


    private static List<User> userList() {
        List<User> users = Lists.newArrayList();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setName("lyy" + i);
            user.setId(i);
            users.add(user);
        }
        return users;
    }
}
