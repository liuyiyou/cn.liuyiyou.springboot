package cn.liuyiyou.springboot.hello.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * @author: liuyiyou.cn
 * @date: 2018/12/7
 * @version: V1.0
 */
@Slf4j
@RestController
public class HelloController {

    @PostConstruct
    public void logSomething() {
        log.info("Sample Info Message");
        log.debug("Sample Debug Message");
        log.trace("Sample Trace Message");
    }

    @GetMapping("/")
    public String sayHello() {
        log.info("Sample Info Message");
        log.debug("Sample Debug Message");
        log.trace("Sample Trace Message");
        return "Hello SpringBoot";
    }

    @GetMapping("/exception")
    public String testException() {
        int i = 1 / 0;
        return "success";
    }
}
