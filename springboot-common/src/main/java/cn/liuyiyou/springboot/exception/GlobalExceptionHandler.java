package cn.liuyiyou.springboot.exception;

import cn.liuyiyou.springboot.result.Result;
import cn.liuyiyou.springboot.result.ResultGenerator;
import io.lettuce.core.RedisConnectionException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;


/**
 * 全局异常处理
 *
 * @author: liuyiyou
 * @date: 2017/11/17
 * Time: 下午1:55
 */

@RestControllerAdvice
@Slf4j
@Configuration
public class GlobalExceptionHandler {


    @ExceptionHandler(RedisConnectionException.class)
    public void redisConnectionException( Exception e){
        log.error("RedisConnectionException::",e);
    }


    @ExceptionHandler
    public Result jsonErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        log.error("error", e);
        return ResultGenerator.genBadReqResult(e.getMessage());
    }



}
