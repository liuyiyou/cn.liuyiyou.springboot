package cn.liuyiyou.springboot.hello.controller;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

/**
 * @author: liuyiyou.cn
 * @date: 2018/12/7
 * @version: V1.0
 */
@Slf4j
@RestController
public class HelloController {
    @Autowired
    private RestTemplate restTemplate;


    @PostConstruct
    public void logSomething() {
        log.info("Sample Info Message");
        log.debug("Sample Debug Message");
        log.trace("Sample Trace Message");
    }

    @GetMapping("/")
    public String sayHello() {
        log.info("Sample Info Message");
        log.debug("Sample Debug Message");
        log.trace("Sample Trace Message");
        return "Hello SpringBoot";
    }

    @GetMapping("/exception")
    public String testException() {
        int i = 1 / 0;
        return "success";
    }

    @PostMapping("/login")
    @ResponseBody
    public String test(@RequestBody User user) {

//        Message message = new Message();
//        message.setCode(200);
//        message.setMsg("success");
//        message.setSuccess(true);
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("username", user.getUsername());
        jsonObj.put("password", user.getPassword());
        HttpEntity<String> formEntity = new HttpEntity(jsonObj.toString(), headers);
        String s = restTemplate.postForEntity("http://localhost:8080/login", formEntity, String.class).getBody();
        return s;
//        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
//        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//        map.add("username","admin");
//        map.add("password","admin123");
//        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
//        ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity("http://localhost:8080/login", map, String.class);
//        return stringResponseEntity.getBody();
    }
}

class Message {
    private int code;
    private String msg;
    private boolean success;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}

class User {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}