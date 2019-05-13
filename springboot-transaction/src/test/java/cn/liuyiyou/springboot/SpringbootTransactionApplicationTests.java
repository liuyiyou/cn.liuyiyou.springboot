package cn.liuyiyou.springboot;

import cn.liuyiyou.springboot.service.CityService;
import cn.liuyiyou.springboot.service.TransactionService;
import cn.liuyiyou.springboot.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootTransactionApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private CityService cityService;

    @Autowired
    private UserService userService;

    @Autowired
    private TransactionService transactionService;


    /**
     * 第一种情况：正常新增两条记录
     */
    @Test
    public void transactionOk() {
        transactionService.addAll();
    }


    /**
     * 方法没有加注释，事务不起作用
     */
    @Test(expected = Exception.class)
    public void transactionFail() {
        transactionService.addAllFail();
    }

    /**
     * 外部方法没有加注解，外部方法调用了带有注解的方法
     */
    @Test
    public void transactionFail2() {
        transactionService.addInNoMethod();
    }


    /**
     * 外部方法有加注解，外部方法调用了不带注释的方法，事务起作用
     */
    @Test
    public void transactionFail3() {
        transactionService.addInNoMethod2();
    }




    @Test
    public void ok() {
        cityService.findAll();
        userService.findAll();
    }
}
