package cn.liuyiyou.springboot.starter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/***
 *
 * @author: liuyiyou.cn
 * @date: 2018/8/20
 * @Copyright 2018 liuyiyou.cn Inc. All rights reserved
 */
@Slf4j
@RestControllerAdvice(annotations = Rest.class)
public class GlobalExceptionHandler {


    @ExceptionHandler(value = Exception.class)
    public Result defaultExceptionHandler(Exception e){
        log.error("异常信息::",e);
        return Result.error(e);
    }


}
