package cn.liuyiyou.springboot.starter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.io.Serializable;

/***
 *
 * @author: liuyiyou.cn
 * @date: 2018/8/20
 * @Copyright 2018 liuyiyou.cn Inc. All rights reserved
 */
@RestControllerAdvice(annotations = Rest.class)
@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
public class GlobalControllerAdvisor implements ResponseBodyAdvice, Serializable {
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        return Result.success(o);
    }


//    @Override
//    public Result beforeBodyWrite(Result result, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
//        log.info(toJSONString(result));
//        return null;
//    }
}
