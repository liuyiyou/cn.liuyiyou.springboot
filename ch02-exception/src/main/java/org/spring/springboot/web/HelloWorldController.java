package org.spring.springboot.web;

import org.spring.springboot.exception.JSONException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Spring Boot HelloWorld 案例
 * <p>
 * Created by liuyiyou.cn on 17/09/27.
 */
@RestController
public class HelloWorldController {

    @RequestMapping("/page")
    public String sayHello() throws Exception {
        throw new Exception("Hello Exception");
    }


    @ExceptionHandler(JSONException.class)
    @RequestMapping("/json")
    public String jsonError() throws Exception {
        throw new JSONException("Json异常");
    }
}
