package cn.liuyiyou.springboot.starter;

import cn.liuyiyou.springboot.starter.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 *
 * @author: liuyiyou.cn
 * @date: 2018/8/20
 * @Copyright 2018 liuyiyou.cn Inc. All rights reserved
 */
@Rest
@Slf4j
public class IndexController {

    @GetMapping("error")
    public String error() {
        return "error";
    }

    @GetMapping("exception")
    public String exception() {
        throw new RuntimeException("错误....");
    }


    @GetMapping("success/list")
    public List<String> successList() {
        return Arrays.asList("a", "b", "c");
    }

    @GetMapping("success/map")
    public Map<String, String> successMap() {
        Map<String, String> result = new HashMap<>();
        result.put("key", "value");
        return result;
    }

    @GetMapping("success")
    public String success() {
        return "success";
    }

    @GetMapping("success2")
    public String success2(@RequestParam("id") String id) {
        log.info("id::"+id);
        return "success";
    }


    @GetMapping("user")
    public List<User> users() {

        return Arrays.asList(new User() {{
            setId("1");
            setName("lyy");
        }},new User() {{
            setId("2");
            setName("yiyou");
        }});
    }


    @GetMapping("void")
    public void isVoid() {
        System.out.println("just void success");
    }
}
