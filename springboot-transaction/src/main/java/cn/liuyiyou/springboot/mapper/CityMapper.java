package cn.liuyiyou.springboot.mapper;

import cn.liuyiyou.springboot.entity.City;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityMapper {


    City findByName(@Param("cityName") String cityName);

    List<City> findAll();

    int add(City city);
}
