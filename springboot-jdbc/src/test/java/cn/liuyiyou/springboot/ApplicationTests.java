package cn.liuyiyou.springboot;

import cn.liuyiyou.springboot.mapper.CityDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    private CityDao userDao;

    @Test
    public void contextLoads() {
        userDao.getCitys().forEach(System.out::println);
    }

}
