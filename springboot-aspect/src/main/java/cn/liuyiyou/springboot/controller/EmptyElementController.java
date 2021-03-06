package cn.liuyiyou.springboot.controller;

import cn.liuyiyou.springboot.vo.EmptyElementFilter;
import cn.liuyiyou.springboot.vo.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Spring Boot HelloWorld 案例
 * <p>
 * Created by liuyiyou.cn on 17/09/27.
 */
@RestController
public class EmptyElementController {

    @RequestMapping("/")
    @EmptyElementFilter
    public User sayHello(@RequestBody User user) {
        return user;
    }
}
