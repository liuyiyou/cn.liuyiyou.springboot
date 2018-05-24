package cn.liuyiyou.springboot.service;

import cn.liuyiyou.springboot.model.City;

/**
 * 城市业务逻辑接口类
 * <p>
 * Created by liuyiyou.cn on 02/05/2017.
 */
public interface ICityService {

    /**
     * 根据城市名称，查询城市信息
     *
     * @param cityName
     */
    City findCityByName(String cityName);


    boolean addCity(City city);
}
