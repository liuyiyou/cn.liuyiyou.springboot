package cn.liuyiyou.springboot.service.impl;

import cn.liuyiyou.springboot.mapper.blog.UserMapper;
import cn.liuyiyou.springboot.mapper.iba.UserDeliveryMapper;
import cn.liuyiyou.springboot.mapper.test.OrderMapper;
import cn.liuyiyou.springboot.model.Order;
import cn.liuyiyou.springboot.model.User;
import cn.liuyiyou.springboot.model.UserDelivery;
import cn.liuyiyou.springboot.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * User: liuyiyou
 * Date: 2017/9/9
 * Time: 上午11:46
 */
@Service
public class UserService implements IUserService {

    private Logger logger = LoggerFactory.getLogger(getClass());


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private UserDeliveryMapper userDeliveryMapper;


    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public User getUserById(Long id) {
        User user = userMapper.selectByPrimaryKey(id);
        logger.info("user.loginName::{}", user.getLoginName());
        return user;
    }

    @Override
    public User getRedisUserById(Long id) {
        logger.info("redisTemplate::{}", redisTemplate);
        String key = "user_" + id;
        ValueOperations<String, User> operations = redisTemplate.opsForValue();
        // 缓存存在
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            User user = operations.get(key);
            logger.info("UserService.getRedisUserById() : 从缓存中获取用户 >> " + user.getLoginName());
            return user;
        }
        // 从 DB 中获取城市信息
        User user = getUserById(id);
        // 插入缓存
        operations.set(key, user);
        logger.info("UserService.getRedisUserById() : 用户插入缓存 >> " + user.getLoginName());
        return user;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int addUser(User user) {
        int result = userMapper.insert(user);
        int a = 1 / 0;
        return result;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addOrder(Order order) {
        orderMapper.insert(order);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void unionUpdateRight(User user, Order order) {
        userMapper.insert(user);
        orderMapper.insert(order);
    }

    /**
     * 跨库更新数据异常,第一个回滚   ,第二个没有回滚
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void unionUpdateFaild(User user, Order order) {
        orderMapper.insert(order);
        userMapper.insert(user);
        int a = 1 / 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void unionUpdateFaild(User user, UserDelivery userDelivery) {

        userDeliveryMapper.insert(userDelivery);
        userMapper.insert(user);
        int a = 1 / 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void unionUpdateFaild(Order order, UserDelivery userDelivery) {
        userDeliveryMapper.insert(userDelivery);
        orderMapper.insert(order);
        int a = 1 / 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void unionAllRight(User user, Order order, UserDelivery userDelivery) {
        userMapper.insert(user);
        orderMapper.insert(order);
        userDeliveryMapper.insert(userDelivery);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void unionAllFaild(User user, Order order, UserDelivery userDelivery) {
        orderMapper.insert(order);
        userDeliveryMapper.insert(userDelivery);
        userMapper.insert(user);
        int a = 1 / 0;
    }


}
