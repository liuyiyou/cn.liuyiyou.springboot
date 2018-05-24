package cn.liuyiyou.springboot.exception;

import cn.liuyiyou.springboot.result.HttpCode;
import cn.liuyiyou.springboot.result.Result;
import cn.liuyiyou.springboot.result.ResultGenerator;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: liuyiyou
 * @date: 2017/11/17
 * Time: 下午1:55
 */

@RestControllerAdvice
//@RestController
@Log
public class GlobalExceptionHandler {

    public static final String DEFAULT_ERROR_VIEW = "error";

    @ExceptionHandler
    public Result jsonErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        if (e instanceof org.springframework.web.servlet.NoHandlerFoundException) {
            return ResultGenerator.genBadReqResult(HttpCode.NOT_FOUND,"页面不存在");
        }
        return ResultGenerator.genBadReqResult(e.getMessage());
    }

//    @ExceptionHandler(NormalExceptionHandler.class)
//    public Result normalException(HttpServletRequest req, Exception e) throws Exception {
//        log.info("普通异常:"+e.getMessage());
//        return ResultGenerator.genBadReqResult(e.getMessage());
//    }



}
