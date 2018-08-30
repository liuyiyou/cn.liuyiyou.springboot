package cn.liuyiyou.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 *
 * @author: liuyiyou.cn
 * @date: 2018/8/30
 * @Copyright 2018 liuyiyou.cn Inc. All rights reserved
 */
@RestController
@RequestMapping("/user/")
public class UserController {

    @GetMapping("/list")
    public String list() {
        return "Hello Spring Security";
    }
}
