package cn.liuyiyou.springboot.dubbo.impl;

import cn.liuyiyou.springboot.entity.City;
import cn.liuyiyou.springboot.dubbo.CityDubboService;
import com.alibaba.dubbo.config.annotation.Service;

/**
 * 城市业务 Dubbo 服务层实现层
 *
 * Created by liuyiyou.cn on 28/02/2017.
 */
// 注册为 Dubbo 服务
@Service(version = "1.0.0")
public class CityDubboServiceImpl implements CityDubboService {

    public City findCityByName(String cityName) {
        return new City(1L,2L,"温岭","是我的故乡");
    }
}
