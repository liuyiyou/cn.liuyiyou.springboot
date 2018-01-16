package cn.liuyiyou.springboot.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author lyy
 * @date 17-12-18
 */
@Aspect
@Component
public class EmptyElementFilterAspect {

    private static final Logger logger = LoggerFactory.getLogger(EmptyElementFilterAspect.class);


    @Pointcut("@annotation(org.spring.springboot.vo.EmptyElementFilter)")
    public void pointcut() {
        logger.info("==========pointcut===========");
    }

    @Before("pointcut()")
    public void before() {
        logger.info("====================before=======================");
    }

//    @Around("pointcut()")
//    public void around() {
//        logger.info("====================around=======================");
//    }

    @After("pointcut()")
    public void after() {
        logger.info("====================after=======================");
    }

    @PostConstruct
    public void init() {
        System.out.println("====================init=======================");
    }

}
