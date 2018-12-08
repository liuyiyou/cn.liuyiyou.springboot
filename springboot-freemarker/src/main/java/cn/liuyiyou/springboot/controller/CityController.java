package cn.liuyiyou.springboot.controller;

import cn.liuyiyou.springboot.entity.City;
import cn.liuyiyou.springboot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * 城市 Controller 实现 Restful HTTP 服务
 * <p>
 * Created by liuyiyou.cn on 07/02/2017.
 */
@Controller
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping(value = "/api/city/{id}")
    public String findOneCity(Model model, @PathVariable("id") Long id) {
        model.addAttribute("city", cityService.findCityById(id));
        return "city";
    }

    @GetMapping(value = "/api/city")
    public String findAllCity(Model model) {
        List<City> cityList = cityService.findAllCity();
        model.addAttribute("cityList", cityList);
        return "cityList";
    }
}
