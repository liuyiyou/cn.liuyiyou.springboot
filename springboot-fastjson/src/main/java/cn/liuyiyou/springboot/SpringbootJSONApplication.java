package cn.liuyiyou.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@SpringBootApplication
@RestController
public class SpringbootJSONApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootJSONApplication.class, args);
    }


    @GetMapping("/")
    public User user() {
        return new User().set_string("bbbbbb").setPath("/prod/20180912.jpg").setDate(new Date());
    }


    @GetMapping("/fastjson")
    public RefundResultFastJsonVo fastjson() {
        return new RefundResultFastJsonVo().setErrReturnMsg("ErrReturnMsg").setReturnCode(200).setReturnMsg("ReturnMsg");
    }

    @GetMapping("/gson")
    public RefundResultGsonVo gson() {
        return new RefundResultGsonVo().setErrReturnMsg("ErrReturnMsg").setReturnCode(200).setReturnMsg("ReturnMsg");
    }

    @GetMapping("/jackson")
    public RefundResultJacksonVo jackson() {

        return new RefundResultJacksonVo().setErrReturnMsg("ErrReturnMsg").setReturnCode(200).setReturnMsg("ReturnMsg");
    }

}

