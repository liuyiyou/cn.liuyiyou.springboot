package cn.liuyiyou.springboot.service;

import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author: liuyiyou
 * @date: 2017/12/13
 * Time: 下午2:54
 */
public interface HelloApi {


    void addBody(@RequestBody Object xxx);
}
