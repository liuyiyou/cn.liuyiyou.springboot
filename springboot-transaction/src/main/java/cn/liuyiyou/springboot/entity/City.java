package cn.liuyiyou.springboot.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 城市实体类
 * <p>
 * Created by liuyiyou.cn on on 07/02/2017.
 */
@Data
@Accessors(chain = true)
public class City {

    /**
     * 城市编号
     */
    private Long id;

    /**
     * 省份编号
     */
    private Long provinceId;

    /**
     * 城市名称
     */
    private String cityName;


}
