package cn.liuyiyou.springboot.controller;

import cn.liuyiyou.springboot.model.User;
import cn.liuyiyou.springboot.model.User1;
import cn.liuyiyou.springboot.model.User2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController("restcontroller")
@RequestMapping("/rest/")
public class HelloRestController {

    /**
     * dd
     *
     * @return
     */
    @GetMapping("auser1")
    public User1 user1() {
        User1 u = new User1();
        u.setId(1019773184273002497L);
        u.setName("没有加注解");
        return u;
    }

    /**
     * aa
     * dd
     *
     * @return
     */
    @GetMapping("auser2")
    public User2 user2() {
        User2 u = new User2();
        u.setId(1019773184273002497L);
        u.setName("加注释");
        return u;
    }

    /**
     * 返回json
     *
     * @return
     */
    @GetMapping("hello")
    public String sayHello() {
        return "Hello,World!";
    }


    /**
     * 去寻找 templates/rest/returnTemplateDefault.html
     *
     * @return
     */
    @GetMapping({"/returnTemplateDefault"})
    public ModelAndView returnTemplateDefault() {
        return new ModelAndView();
    }

    /**
     * 去寻找 templates/hello1.html
     *
     * @return
     */
    @GetMapping({"/returnTemplate"})
    public ModelAndView returnTemplate() {
        return new ModelAndView("hello1");
    }

    @GetMapping({"/returnMap"})
    public Map returnMap() {
        return new HashMap();
    }


    @GetMapping("/user")
    public User getUser() {
        return new User() {{
            setName("中文");
            setId(1);
            setBirthDay(new Date());
        }};
    }


    @GetMapping("/userlist")
    public List<User> getUserList() {
        return userList();
    }


    private static List<User> userList() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setName("lyy" + i);
            user.setId(i);
            user.setBirthDay(new Date());
            users.add(user);

        }
        return users;
    }
}
