package cn.liuyiyou.springboot.controller;

import cn.liuyiyou.springboot.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/***
 *
 * 关于返回值说明在这里：
 * https://docs.spring.io/spring/docs/5.1.3.RELEASE/spring-framework-reference/web.html#mvc-ann-return-types
 * @author: liuyiyou
 * @date: 2018/1/17
 */
@Controller
@RequestMapping("/controller/")
public class HelloController {


    /**
     * 返回templates/controller/hello1.thml
     *
     * @return
     */
    @GetMapping("hello1")
    public String hello1() {
        return "controller/hello1";
    }

    /**
     * 返回templates/hello1.thml
     *
     * @return
     */
    @GetMapping("hello")
    public String hello() {
        return "hello1";
    }

    /**
     * 返回templates/hello2.thml
     *
     * @return
     */
    @GetMapping("hello2")
    public String hello2() {
        return "hello2";
    }

    /**
     * 加了@ResponseBody 返回 hello
     *
     * @return
     */
    @GetMapping("helloJson")
    @ResponseBody
    public String helloJson() {
        return "hello";
    }

    /**
     * 这个有点巧妙，返回的是 templates/controller/returnMap.html
     *
     * @return
     */
    @GetMapping({"/returnMap"})
    public Map returnMap() {
        return new HashMap();
    }


    @GetMapping("/returnSet")
    public Set retrunSet() {
        Set<String> set = new HashSet<>();
        set.add("aa");
        return set;
    }

    /**
     * Cannot generate variable name for non-typed Collection return type and an empty Collection value
     *
     * @return
     */
    @GetMapping("/returnSetError")
    public Set retrunSetError() {
        return new HashSet<>();
    }

    @GetMapping("/returnList")
    public List returnList() {
        List<String> list = new ArrayList<>();
        list.add("aa");
        return list;
    }

    @GetMapping("/returnListError")
    public List returnListError() {
        return new ArrayList();
    }


    @GetMapping("/returnInteger")
    public Integer returnInteger() {
        return 0;
    }


    @GetMapping({"/returnMapJson"})
    @ResponseBody
    public Map returnMapJson() {
        return new HashMap();
    }

    /**
     * 返回  templates/controller/user.html
     *
     * @return
     */
    @GetMapping("/returnObject")
    public User getUser() {
        return new User() {{
            setName("中文");
            setId(1);
        }};
    }
}
