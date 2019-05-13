package cn.liuyiyou.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@SpringBootApplication
@RestController
public class SpringbootFastjsonApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootFastjsonApplication.class, args);
    }


    @GetMapping("/")
    public User user() {
        return new User().set_string("bbbbbb").setPath("/prod/20180912.jpg").setDate(new Date());
    }

}

