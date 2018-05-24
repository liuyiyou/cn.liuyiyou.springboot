package cn.liuyiyou.springboot.web;

import cn.liuyiyou.springboot.exception.NormalExceptionHandler;
import cn.liuyiyou.springboot.result.Result;
import cn.liuyiyou.springboot.result.ResultGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Spring Boot 通用异常处理 案例
 * <p>
 * Created by liuyiyou.cn on 17/09/27.
 */
@RestController("xxxx")
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

    @RequestMapping("/normal")
    @ExceptionHandler(NormalExceptionHandler.class)
    public Result normalException (){
        throw  new NormalExceptionHandler("普通异常");
    }




}
