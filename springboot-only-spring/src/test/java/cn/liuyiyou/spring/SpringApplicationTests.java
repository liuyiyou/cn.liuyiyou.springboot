package cn.liuyiyou.spring;

import cn.liuyiyou.spring.propertysource.DataSourceConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//@RunWith(SpringRunner.class)
//@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class SpringApplicationTests {

    @Autowired
    private DataSourceConfig dataSourceConfig;

    @Test
    public void contextLoads() {
        System.out.println(dataSourceConfig.getPassword());
        System.out.println(dataSourceConfig.getUrl());
        System.out.println(dataSourceConfig.getDriverClassName());
    }

}
