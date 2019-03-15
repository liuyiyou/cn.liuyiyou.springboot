package cn.liuyiyou.springboot.service;

import cn.liuyiyou.springboot.entity.City;
import cn.liuyiyou.springboot.mapper.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 城市业务逻辑实现类
 * <p>
 * Created by liuyiyou.cn on 07/02/2017.
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityMapper cityMapper;

    @Override
    public City findCityByName(String cityName) {
        return cityMapper.findByName(cityName);
    }

    @Override
    public List<City> findAll() {
        return cityMapper.findAll();
    }

    @Override
    @Transactional
    public int addCity(City city) {
        return cityMapper.add(city);

    }

}
