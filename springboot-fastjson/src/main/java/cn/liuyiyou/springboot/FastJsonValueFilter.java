package cn.liuyiyou.springboot;

import com.alibaba.fastjson.serializer.ValueFilter;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: liuyiyou.cn
 * @date: 2018/12/29
 * @version: V1.0
 */
public class FastJsonValueFilter implements ValueFilter {
    /**
     * fastjson 值过滤器
     */
    @Override
    public Object process(Object object, String name, Object value) {
        if (object instanceof User) {
            User user = (User) object;
            if(value!=null && value.equals(user.get_string())){
                return "preixx:::::::::" + value;
            }
        }
        return value;
    }
}
