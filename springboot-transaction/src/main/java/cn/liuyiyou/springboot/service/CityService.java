package cn.liuyiyou.springboot.service;

import cn.liuyiyou.springboot.entity.City;

import java.util.List;

public interface CityService {

    /**
     * 根据城市名称，查询城市信息
     *
     * @param cityName
     */
    City findCityByName(String cityName);

    /**
     * 得到所有城市
     *
     * @return
     */
    List<City> findAll();

    int addCity(City city);
}
