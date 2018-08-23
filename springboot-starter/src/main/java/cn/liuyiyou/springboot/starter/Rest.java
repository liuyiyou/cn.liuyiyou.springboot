package cn.liuyiyou.springboot.starter;

import org.springframework.core.annotation.AliasFor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/***
 *
 * @author: liuyiyou.cn
 * @date: 2018/8/20
 * @Copyright 2018 liuyiyou.cn Inc. All rights reserved
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@RestController
@RequestMapping
public @interface Rest {

    @AliasFor(annotation = RequestMapping.class, attribute = "value")
    String[] value() default {};
}
