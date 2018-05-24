package cn.liuyiyou.springboot.mybatis;

import cn.liuyiyou.springboot.model.Order;
import cn.liuyiyou.springboot.model.User;
import cn.liuyiyou.springboot.model.UserDelivery;
import cn.liuyiyou.springboot.service.IUserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class UserServiceTest extends AbstractTest {

    @Autowired
    private IUserService userService;


    @Test
    public void getUserByIdTest() {
        userService.getUserById(1L);
    }

    @Test
    public void transactionTest() {
        User user = getUser();
        userService.addUser(user);
    }


    @Test
    public void addOrder() {
        Order order = getOrder();
        userService.addOrder(order);
    }


    @Test
    public void redisTest() {
        userService.getRedisUserById(1L);
    }

    /**
     * 住数据源--从数据源
     */
    @Test
    public void unionAddTest() {
        User user = getUser();
        Order order = getOrder();
        userService.unionUpdateRight(user, order);
    }


    @Test
    public void unionAddFailTest() {
        User user = getUser();
        Order order = getOrder();
        userService.unionUpdateFaild(user, order);
    }

    /**
     *
     */
    @Test
    public void unionAddFail3Test() {
        Order order = getOrder();
        UserDelivery userDelivery = getUserDelivery();
        userService.unionUpdateFaild(order, userDelivery);
    }


    @Test
    public void unionAllAddRightTest() {
        User user = getUser();
        Order order = getOrder();
        UserDelivery userDelivery = getUserDelivery();
        userService.unionAllRight(user, order, userDelivery);
    }


    @Test
    public void unionAllAddFaildTest() {
        User user = getUser();
        Order order = getOrder();
        UserDelivery userDelivery = getUserDelivery();
        userService.unionAllFaild(user, order, userDelivery);
    }


    public User getUser() {
        User user = new User();
        user.setName("中文");
        user.setLoginName("springboot");
        user.setCompanyId(1L);
        user.setCityId(1L);
        user.setOfficeId(1L);
        user.setCreateDate(new Date());
        return user;
    }

    public Order getOrder() {
        Order order = new Order();
        order.setWorkerId(2);
        order.setOrderName("abc");
        return order;
    }

    public UserDelivery getUserDelivery() {
        UserDelivery userDelivery = new UserDelivery();
        userDelivery.setId(1L);
        userDelivery.setConsignee("测试-lyy");
        return userDelivery;
    }
}
