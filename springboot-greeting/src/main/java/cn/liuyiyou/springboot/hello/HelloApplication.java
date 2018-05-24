package cn.liuyiyou.springboot.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@SpringBootApplication
@RestController
public class HelloApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloApplication.class, args);
    }


    @RequestMapping("/hello")
    public String sayHello() {
        return "Hello SpringBoot";
    }


    private static final Logger logger = LoggerFactory
            .getLogger(HelloApplication.class);

    @PostConstruct
    public void logSomething() {
        logger.info("Sample Info Message");
        logger.debug("Sample Debug Message");
        logger.trace("Sample Trace Message");
    }
}
