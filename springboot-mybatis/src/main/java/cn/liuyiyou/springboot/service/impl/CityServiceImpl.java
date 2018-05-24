package cn.liuyiyou.springboot.service.impl;

import cn.liuyiyou.springboot.dao.CityDao;
import cn.liuyiyou.springboot.domain.City;
import cn.liuyiyou.springboot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 城市业务逻辑实现类
 * <p>
 * Created by liuyiyou.cn on 07/02/2017.
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao cityDao;

    @Override
    public City findCityByName(String cityName) {
        return cityDao.findByName(cityName);
    }

    @Override
    public List<City> findAll() {
        return cityDao.findAll();
    }

}
