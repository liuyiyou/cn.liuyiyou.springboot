package cn.liuyiyou.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import redis.clients.jedis.Jedis;

/**
 * User: liuyiyou
 * Date: 2017/9/10
 * Time: 下午4:57
 */
@Controller
public class HomeController {

    @Autowired
    private Jedis jedis;


    @RequestMapping("/")
    public String index() {
        System.out.println("result::"+jedis.ping());
        return "index";
    }


}
