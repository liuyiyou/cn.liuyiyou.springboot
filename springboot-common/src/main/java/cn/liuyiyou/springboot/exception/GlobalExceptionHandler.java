package cn.liuyiyou.springboot.exception;

import cn.liuyiyou.springboot.result.ResultGenerator;
import lombok.extern.slf4j.Slf4j;
import org.spring.springboot.result.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

import static org.spring.springboot.result.ResultGenerator.genBadReqResult;

/**
 * 全局异常处理
 *
 * @author: liuyiyou
 * @date: 2017/11/17
 * Time: 下午1:55
 */

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler
    public Result jsonErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        log.error("error", e);
        return ResultGenerator.genBadReqResult(e.getMessage());
    }


}
