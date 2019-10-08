package cn.liuyiyou.springboot;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.lang.reflect.Type;

public class OssPathSerializer implements ObjectSerializer {

    @Override
    public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features) throws IOException {
        String path = (String) object;
        serializer.write(!StringUtils.isEmpty(path) ? "http://oss.liuyiyou.com/" + path : "");
    }

}
