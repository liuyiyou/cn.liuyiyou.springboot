package cn.liuyiyou.springboot.starter;

import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.List;

/***
 *
 * @author: liuyiyou.cn
 * @date: 2018/8/20
 * @Copyright 2018 liuyiyou.cn Inc. All rights reserved
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer{

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        SerializeConfig config = SerializeConfig.globalInstance;
        config.put(BigInteger.class, ToStringSerializer.instance);
        config.put(Long.class,ToStringSerializer.instance);
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializeConfig(config);
        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
        StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
        converters.add(stringHttpMessageConverter);
        converters.add(fastJsonHttpMessageConverter);
    }
}
