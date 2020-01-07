//package cn.liuyiyou.springboot;
//
//import com.alibaba.fastjson.serializer.SerializerFeature;
//import com.alibaba.fastjson.support.config.FastJsonConfig;
//import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.converter.HttpMessageConverter;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import java.util.List;
//
//import static com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue;
//import static com.alibaba.fastjson.serializer.SerializerFeature.WriteNullListAsEmpty;
//import static com.alibaba.fastjson.serializer.SerializerFeature.WriteNullNumberAsZero;
//import static com.alibaba.fastjson.serializer.SerializerFeature.WriteNullStringAsEmpty;
//
///**
// * @author: liuyiyou.cn
// * @date: 2018/12/21
// * @version: V1.0
// */
////@Configuration
//public class MvcConfig implements WebMvcConfigurer {
//
//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        FastJsonHttpMessageConverter fastJsonConverter = new FastJsonHttpMessageConverter();
//        FastJsonConfig fastJsonConfig = new FastJsonConfig();
//        fastJsonConfig.getSerializeConfig().put(String.class,new OssPathSerializer());
////        SerializeConfig.getGlobalInstance().put(String.class, new OssPathSerializer());
////        fastJsonConfig.setSerializeFilters(new FastJsonValueFilter());
//        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat,
//                WriteNullStringAsEmpty,
//                WriteNullNumberAsZero,
//                WriteNullListAsEmpty,
//                WriteMapNullValue);
//
////        fastJsonConfig.setSerializeFilters(new FastJsonValueFilter());
//        fastJsonConverter.setFastJsonConfig(fastJsonConfig);
//        converters.add(0,fastJsonConverter);
//    }
//
//
//}
