package cn.liuyiyou.springboot.controller;

import cn.liuyiyou.springboot.entity.User;
import cn.liuyiyou.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 错误码案例
 * <p>
 * Created by liuyiyou.cn on 16/4/26.
 */
@RestController
@RequestMapping("/validator")
public class ValidatorController {

    @Autowired
    private UserService userService;

    @GetMapping("/_500")
    public String _500() {
        int i = 1 / 0;
        return "success";
    }

    @GetMapping("/service")
    public boolean serivce() {
        userService.validatorParam(null);
        return true;
    }

    /**
     * {
     * "id":1
     * }
     *
     * @param user
     * @return
     */
    @PostMapping("/list")
    public String list(@RequestBody @Valid User user) {
        return "success";
    }


    @GetMapping("/get")
    @Validated
    public String get(@RequestParam("id") @Min(value = 0, message = "只能是数字") Integer id) {
        return "success";
    }

    @GetMapping("/get2")
    @Validated
    public String get2(@RequestParam("id") @NotNull(message = "只能是数字") Integer id) {
        return "success";
    }
}