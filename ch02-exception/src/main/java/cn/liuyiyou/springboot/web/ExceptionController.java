package cn.liuyiyou.springboot.web;

import cn.liuyiyou.springboot.result.Result;
import cn.liuyiyou.springboot.result.ResultGenerator;
import lombok.extern.slf4j.Slf4j;
import org.spring.springboot.result.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.spring.springboot.result.ResultGenerator.genSuccessResult;

/**
 * Spring Boot 通用异常处理 案例
 * <p>
 * Created by liuyiyou.cn on 17/09/27.
 */
@RestController
@Slf4j
public class ExceptionController {

    @RequestMapping("/exception")
    public Result newException() throws Exception {
        throw new Exception("Hello Exception");
    }


    @RequestMapping("/div")
    public Result sayHello() throws Exception {
        log.info("div.......");
        int result = 1 / 0;
        return ResultGenerator.genSuccessResult();
    }


}
