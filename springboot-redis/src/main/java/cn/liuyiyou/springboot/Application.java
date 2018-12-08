package cn.liuyiyou.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @author liuyiyou.cn
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

//    @Bean
//    public  <V extends Serializable> RedisTemplate<String, V> redisTemplate(){
//        return new RedisTemplate<String, V>();
//    }


}
