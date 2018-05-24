package cn.liuyiyou.springboot.controller;

import cn.liuyiyou.springboot.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/rest/")
public class HelloRestController {

    /**
     * 返回json
     *
     * @return
     */
    @RequestMapping("hello")
    public String sayHello() {
        return "Hello,World!";
    }


    /**
     * 去寻找 templates/rest/returnTemplateDefault.html
     *
     * @return
     */
    @RequestMapping({"/returnTemplateDefault"})
    public ModelAndView returnTemplateDefault() {
        return new ModelAndView();
    }

    /**
     * 去寻找 templates/hello1.html
     *
     * @return
     */
    @RequestMapping({"/returnTemplate"})
    public ModelAndView returnTemplate() {
        return new ModelAndView("hello1");
    }

    @RequestMapping({"/returnMap"})
    public Map returnMap() {
        return new HashMap();
    }



    @RequestMapping("/user")
    public User getUser() {
        return new User() {{
            setName("中文");
            setId(1);
            setBirthDay(new Date());
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
            user.setBirthDay(new Date());
            users.add(user);

        }
        return users;
    }
}
