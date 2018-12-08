package cn.liuyiyou.springboot.mapper;

import cn.liuyiyou.springboot.entity.City;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 城市 DAO 接口类
 *
 * Created by liuyiyou.cn on 07/02/2017.
 */
public interface CityDao {

    /**
     * 根据城市名称，查询城市信息
     *
     * @param cityName 城市名
     */
    City findByName(@Param("cityName") String cityName);

    List<City> findAll();
}
