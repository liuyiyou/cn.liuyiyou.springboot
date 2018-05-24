package cn.liuyiyou.springboot.dao;

import cn.liuyiyou.springboot.entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/***
 * @author: liuyiyou
 * @date: 2018/5/24
 */
@Repository
public class CityDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<City> getCitys() {
        List<City> cities = jdbcTemplate.query("SELECT * FROM  city", (resultSet, i) -> City.builder()
                .cityName(resultSet.getString("city_name"))
                .id(resultSet.getLong(1))
                .description(resultSet.getString("description"))
                .provinceId(resultSet.getLong("province_id")).build());
        return cities;
    }
}
