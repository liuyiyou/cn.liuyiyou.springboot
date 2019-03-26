package cn.liuyiyou.springboot.hello.controller;

import cn.liuyiyou.springboot.hello.HelloApplication;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Map;
import java.util.function.BiConsumer;

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
        RequestMappingHandlerMapping bean = HelloApplication.applicationContext.getBean(RequestMappingHandlerMapping.class);
        Map<RequestMappingInfo, HandlerMethod> handlerMethods = bean.getHandlerMethods();
        handlerMethods.forEach((requestMappingInfo, handlerMethod) -> {
            System.out.println(requestMappingInfo.getName());
            System.out.println(handlerMethod.getMethod().getName());
        });
        Arrays.asList(bean).forEach(System.out::println);
        log.info("Sample Info Message");
        log.debug("Sample Debug Message");
        log.trace("Sample Trace Message");
        return "Hello SpringBoot";
    }


    @GetMapping("user")
    public User user() {
       User user = new User();
       user.setId(1);
       user.setName(null);
       return user;
    }

    @GetMapping("/exception")
    public String testException() {
        int i = 1 / 0;
        return "success";
    }
}

@Data
class User{
    private Integer id;
    private String name;
}
