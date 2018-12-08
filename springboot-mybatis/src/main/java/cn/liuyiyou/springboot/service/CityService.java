package cn.liuyiyou.springboot.service;

import cn.liuyiyou.springboot.entity.City;

import java.util.List;

/**
 * 城市业务逻辑接口类
 *
 * Created by liuyiyo.cn on 07/02/2017.
 */
public interface CityService {

    /**
     * 根据城市名称，查询城市信息
     * @param cityName
     */
    City findCityByName(String cityName);

    /**
     * 得到所有城市
     * @return
     */
    List<City> findAll();
}
