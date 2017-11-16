package cn.liuyiyou;

import cn.liuyiyou.springboot.SpringbootJedisApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootJedisApplication.class)
public class SpringbootJedisApplicationTests {


    @Autowired
    Jedis jedis;


    @Test
    public void contextLoads() {
    }

    @Test
    public void jedisTest() {
        // Jedis jedis = jedisPool.getResource();
        System.out.println(jedis.get("name"));
    }


    /**
     * 字符串操作
     */

    /**
     * Hash操作
     */
    @Test
    public void HashOpt() {
        //Jedis jedis = jedisPool.getResource();

        Map<String, String> values = new HashMap<>();
        values.put("name", "redis tutorial");
        values.put("description", "redis basic commands for caching");
        values.put("likes", "20");
        values.put("xxx", "yyyy");
        jedis.hmset("w3ckey", values);


        System.out.println(jedis.hget("w3ckey","name"));
    }
}
