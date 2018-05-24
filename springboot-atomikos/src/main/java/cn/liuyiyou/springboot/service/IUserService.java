package cn.liuyiyou.springboot.service;


import cn.liuyiyou.springboot.model.Order;
import cn.liuyiyou.springboot.model.User;
import cn.liuyiyou.springboot.model.UserDelivery;

/**
 * User: liuyiyou
 * Date: 2017/9/9
 * Time: 上午11:45
 */
public interface IUserService {

    User getUserById(Long id);


    User getRedisUserById(Long id);


    int addUser(User user);

    void addOrder(Order order);


    /**
     * 测试多个数据源,多个数据库在同一个机器上
     * @param user
     * @param order
     */
    void unionUpdateRight(User user, Order order);

    /**
     * 测试多个数据分布式事务
     * @param user
     * @param order
     */
    void unionUpdateFaild(User user, Order order);

    void unionUpdateFaild(User user, UserDelivery userDelivery) ;

    void unionUpdateFaild(Order order, UserDelivery userDelivery) ;

    /**
     * 测试多个数据源,多个数据库在不同一个机器上,成功
     * @param user
     * @param order
     * @param userDelivery
     */
    void unionAllRight(User user, Order order, UserDelivery userDelivery);

    /**
     * 测试多个数据源,多个数据库在不同一个机器上 ,事务回滚
     * @param user
     * @param order
     * @param userDelivery
     */
    void unionAllFaild(User user, Order order, UserDelivery userDelivery);
}
