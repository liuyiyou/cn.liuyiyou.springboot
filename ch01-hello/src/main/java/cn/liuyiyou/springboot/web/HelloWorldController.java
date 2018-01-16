package cn.liuyiyou.springboot.web;

import org.spring.springboot.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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
        System.out.println("先休息");
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
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setName("lyy" + i);
            user.setId(i);
            users.add(user);
        }
        return users;
    }
}
