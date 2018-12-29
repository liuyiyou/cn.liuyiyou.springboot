package cn.liuyiyou.springboot.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

/**
 * @author: liuyiyou.cn
 * @date: 2018/12/28
 * @version: V1.0
 */
@Service
@Validated
public class UserService {


    public boolean noValidator() {
        return true;
    }

    public boolean validatorParam(@NotNull(message = "参数不能为空") String param) {
        return true;
    }
}
