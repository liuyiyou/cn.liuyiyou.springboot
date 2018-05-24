package cn.liuyiyou.springboot;

import cn.liuyiyou.springboot.web.ExceptionController;
import groovy.transform.ASTTest;
import org.junit.Test;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/***
 * @author: liuyiyou
 * @date: 2018/1/19
 */
public class AnnotationTest {


    @Test
    public void  test(){
        RestController annotation = AnnotationUtils.findAnnotation(ExceptionController.class, RestController.class);
        System.out.println(annotation.value());
        RestController annotation1 = AnnotationUtils.findAnnotation(RestController.class, RestController.class);
        System.out.println(annotation1.value());
    }
}
