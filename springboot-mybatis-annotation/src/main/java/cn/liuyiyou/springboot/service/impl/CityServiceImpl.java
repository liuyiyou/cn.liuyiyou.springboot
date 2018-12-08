package cn.liuyiyou.springboot.service.impl;

import cn.liuyiyou.springboot.mapper.CityDao;
import cn.liuyiyou.springboot.entity.City;
import cn.liuyiyou.springboot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 城市业务逻辑实现类
 *
 * Created by liuyiyou.cn on 02/05/2017.
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao cityDao;

    public City findCityByName(String cityName) {
        return cityDao.findByName(cityName);
    }

}
