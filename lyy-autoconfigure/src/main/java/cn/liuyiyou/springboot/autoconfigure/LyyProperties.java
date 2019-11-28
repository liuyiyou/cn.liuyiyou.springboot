package cn.liuyiyou.springboot.autoconfigure;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author: liuyiyou.cn
 * @date: 2019/11/28
 * @version: V1.0
 */
@ConfigurationProperties(value = "lyy", ignoreUnknownFields = true)
@Data
public class LyyProperties {

    /**
     * 年龄
     */
    private int age = 18;
    /**
     * 姓名
     */
    private String name = "lyy";
    /**
     * 性别
     */
    private int sex = 0;


}
