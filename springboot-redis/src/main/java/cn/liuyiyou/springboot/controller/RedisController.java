package cn.liuyiyou.springboot.controller;

import cn.liuyiyou.springboot.model.Address;
import cn.liuyiyou.springboot.model.SimpleUser;
import cn.liuyiyou.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author liuyiyou.cn
 */
@RestController
public class RedisController {


    /**
     * 不在Application中初始化RedisTemplate的情况下,能运行,但是生成的key不可用有乱码
     */
//    @Autowired
//    RedisTemplate redisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    //    @Autowired
//    RedisTemplate<String, SimpleUser> simpleUserRedisTemplate;
//
    @RequestMapping("/")
    public String sayHello() {
//        simpleUserRedisTemplate.opsForValue().set("SimpleUser:001", getSimpleUser());
        System.out.println("getValueSerializer::"+redisTemplate.getValueSerializer());
        redisTemplate.opsForValue().set("User:001", getUser());
        return "Hello,World!";
    }


    @RequestMapping("set")
    public String set() {
        redisTemplate.opsForValue().set("User:001", getUser());
        return "Hello,World!";
    }

    @RequestMapping("get")
    public String  get() {
        System.out.println(redisTemplate.opsForValue().get("User:001"));
        return "Hello,World";
    }

    public SimpleUser getSimpleUser() {
        SimpleUser simpleUser = new SimpleUser();
        simpleUser.setId(001);
        simpleUser.setName("lyy");
        return simpleUser;
    }


    public Address getAddress() {
        Address address = new Address();
        address.setProvice("湖南");
        address.setCity("长沙");
        address.setStreet("高新区中电软件园");
        return address;
    }

    public User getUser() {
        User user = new User();
        user.setAddress(getAddress());
        user.setABoolean(true);
        user.setAInteger(1);
        user.setAFloat(1.0F);
        user.setADouble(1.0D);
        user.setDate(new Date());
        user.setList(Arrays.asList(1, 2, 3, 4));
        user.setSet(new HashSet<String>());
        user.setMap(new HashMap<String, String>(16));
        user.setString("中文");
        return user;
    }
}
