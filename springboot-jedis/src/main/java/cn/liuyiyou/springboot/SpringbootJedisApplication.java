package cn.liuyiyou.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;

@SpringBootApplication
public class SpringbootJedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootJedisApplication.class, args);
    }


    @Bean
    public Jedis jedis(){
        return  new Jedis();
    }
}
