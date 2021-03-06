package cn.liuyiyou.springboot.dubbo;

import cn.liuyiyou.springboot.entity.City;

/**
 * 城市业务 Dubbo 服务层
 *
 * Created by liuyiyou.cn on 28/02/2017.
 */
public interface CityDubboService {

    /**
     * 根据城市名称，查询城市信息
     * @param cityName
     */
    City findCityByName(String cityName);
}
