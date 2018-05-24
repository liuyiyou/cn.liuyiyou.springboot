package cn.liuyiyou.springboot.service.impl;

import cn.liuyiyou.springboot.mapper.CityMapper;
import cn.liuyiyou.springboot.model.City;
import cn.liuyiyou.springboot.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CityService implements ICityService {

    @Autowired
    private CityMapper cityMapper;

    @Override
    public City findCityByName(String cityName) {
        return cityMapper.findByName(cityName);
    }

    @Override
    public boolean addCity(City city) {
        return cityMapper.addCity(city)>0;
    }

}
