package cn.liuyiyou.springboot.mapper;

import cn.liuyiyou.springboot.entity.City;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 城市 DAO 接口类
 * <p>
 * Created by liuyiyou.cn on 07/02/2017.
 */
public interface CityMapper {

    /**
     * 获取城市信息列表
     *
     * @return
     */
    List<City> findAllCity();

    /**
     * 根据城市 ID，获取城市信息
     *
     * @param id
     * @return
     */
    City findById(@Param("id") Long id);

    Long saveCity(City city);

    Long updateCity(City city);

    Long deleteCity(Long id);
}
