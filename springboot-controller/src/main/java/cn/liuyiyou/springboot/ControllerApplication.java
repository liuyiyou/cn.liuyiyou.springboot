package cn.liuyiyou.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
//extends WebMvcConfigurerAdapter 过时了
public class ControllerApplication implements WebMvcConfigurer {


    static String dateFormat = "yyyy-MM-dd HH:mm:ss";

//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        FastJsonHttpMessageConverter fastConverter =
//                new FastJsonHttpMessageConverter();
//        FastJsonConfig fastJsonConfig = new FastJsonConfig();
//        SerializeConfig serializeConfig = SerializeConfig.globalInstance;
//        serializeConfig.put(BigInteger.class, ToStringSerializer.instance);
//        serializeConfig.put(Long.class, ToStringSerializer.instance);
//        serializeConfig.put(Long.TYPE, ToStringSerializer.instance);
//        serializeConfig.put(Date.class, new SimpleDateFormatSerializer(dateFormat));
//        fastJsonConfig.setSerializeConfig(serializeConfig);
//        fastConverter.setFastJsonConfig(fastJsonConfig);
//        converters.add(fastConverter);
//    }

    public static void main(String[] args) {
        SpringApplication.run(ControllerApplication.class, args);
    }
}
