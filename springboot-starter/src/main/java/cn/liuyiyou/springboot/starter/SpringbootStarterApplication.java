package cn.liuyiyou.springboot.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Rest
public class SpringbootStarterApplication {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @Bean
    public ResultMessageConvert resultMessageConvert(){
        return new ResultMessageConvert();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringbootStarterApplication.class, args);
    }
}
