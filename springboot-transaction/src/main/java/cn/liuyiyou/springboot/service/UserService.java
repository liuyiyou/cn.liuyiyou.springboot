package cn.liuyiyou.springboot.service;

import cn.liuyiyou.springboot.entity.User;

import java.util.List;

/**
 * @author: liuyiyou.cn
 * @date: 2019/3/15
 * @version: V1.0
 */
public interface UserService {

    int addUser(User user);

    List<User> findAll();
}
