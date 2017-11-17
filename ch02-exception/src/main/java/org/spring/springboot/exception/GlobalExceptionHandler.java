package org.spring.springboot.exception;

import org.spring.springboot.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

import static org.spring.springboot.result.ResultGenerator.genBadReqResult;

/**
 * @author: liuyiyou
 * @date: 2017/11/17
 * Time: 下午1:55
 */

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

    public static final String DEFAULT_ERROR_VIEW = "error";


    @ExceptionHandler(value = JSONException.class)
    @ResponseBody
    public Result jsonErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        return genBadReqResult(e.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName(DEFAULT_ERROR_VIEW);
        return mav;
    }



}
