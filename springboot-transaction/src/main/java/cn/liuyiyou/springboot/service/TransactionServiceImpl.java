package cn.liuyiyou.springboot.service;

import cn.liuyiyou.springboot.entity.City;
import cn.liuyiyou.springboot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: liuyiyou.cn
 * @date: 2019/3/15
 * @version: V1.0
 */
@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private CityService cityService;
    @Autowired
    private UserService userService;

    @Override
    public void addAll() {
        City city = getCity();
        cityService.addCity(city);
        int  i = 1/0;
        User user = getUser();
        userService.addUser(user);
    }


    @Override
    public void addAllFail() {
        City city = getCity();
        cityService.addCity(city);

        int i = 1 / 0;

        User user = getUser();
        userService.addUser(user);
    }


    @Override
    public void addInNoMethod() {
        addUser();
    }

    @Override
    @Transactional
    public void addInNoMethod2() {

        City city = getCity2();
        cityService.addCity(city);

        addUser2();
    }

    @Transactional
    public void addUser() {
        City city = getCity();
        cityService.addCity(city);
        int i = 1 / 0;

        User user = getUser();
        userService.addUser(user);
    }


    private void addUser2() {
        City city = getCity();
        cityService.addCity(city);
        int i = 1 / 0;
        User user = getUser();
        userService.addUser(user);
    }


    private User getUser() {
        User user = new User();
        user.setId(2).setName("lyy");
        return user;
    }

    private City getCity() {
        City city = new City();
        city.setId(11L).setCityName("测试").setProvinceId(11L);
        return city;
    }

    private City getCity2() {
        City city = new City();
        city.setId(12L).setCityName("测试2").setProvinceId(121L);
        return city;
    }


}
