package cn.liuyiyou.springboot.service;

import cn.liuyiyou.springboot.entity.User;
import cn.liuyiyou.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: liuyiyou.cn
 * @date: 2019/3/15
 * @version: V1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional
    public int addUser(User user) {
        return userMapper.add(user);
    }

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }
}
