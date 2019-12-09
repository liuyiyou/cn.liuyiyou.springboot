package cn.liuyiyou.springboot.exception;

import cn.liuyiyou.springboot.response.Response;
import cn.liuyiyou.springboot.response.Result;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


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


    @ExceptionHandler(DefaultException.class)
    public Result defaultErrorHandler(HttpServletRequest request, Exception e, HttpServletResponse response) {
        log.error("404/500/403异常", e);
        String message = e.getMessage();
        JSONObject erroInfo = JSON.parseObject(message);
        int status = erroInfo.getInteger("status");
        switch (status) {
            case 404:
                return Response.fail(erroInfo.getInteger("status"), "找不到页面");
            case 403:
                return Response.fail(erroInfo.getInteger("status"), "没有权限访问");
        }
        return Response.fail(erroInfo.getInteger("status"), e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public Result runTimeErrorHandler(HttpServletRequest request, Exception e, HttpServletResponse response) {
        log.error("系统异常", e);
        if (e instanceof NoHandlerFoundException) {
            return Response.fail(404, "找不到页面");
        }
        return Response.fail(500, e.getMessage());
    }

    @ExceptionHandler
    public void defaultExceptionHandler(HttpServletResponse response, Exception e) throws Exception {
        log.error("error", e);
        JSONObject object = new JSONObject();
        object.put("code", 400);
        object.put("message", e.getMessage());
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Content-type", "application/json;charset=UTF-8");
        response.getWriter().write(JSON.toJSONString(object));
        response.getWriter().flush();
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public void methodArgumentTypeMismatchException(HttpServletResponse response, MethodArgumentTypeMismatchException e) throws IOException {
        log.error("类型转换异常:{}", e);
        JSONObject object = new JSONObject();
        object.put("code", 400);
        object.put("message", "类型检查异常，请检查入参类型");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Content-type", "application/json;charset=UTF-8");
        response.getWriter().write(JSON.toJSONString(object));
        response.getWriter().flush();
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public void validatorException(HttpServletResponse response, MethodArgumentNotValidException e) throws IOException {
        log.info("校验异常");
        List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
        String error = allErrors.get(0).getDefaultMessage();
        JSONObject object = new JSONObject();
        object.put("code", 400);
        object.put("message", error);
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Content-type", "application/json;charset=UTF-8");
        response.getWriter().write(JSON.toJSONString(object));
        response.getWriter().flush();
    }


}
