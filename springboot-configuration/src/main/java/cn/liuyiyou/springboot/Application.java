package cn.liuyiyou.springboot;

import cn.liuyiyou.springboot.config.AddressConfig;
import cn.liuyiyou.springboot.config.UserConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@Slf4j
public class Application {


    @Value("${version}")
    private String version;

    @Value("${test}")
    private String test;

    @Autowired
    private UserConfig userConfig;

    @Autowired
    private AddressConfig addressConfig;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public String test(){
        log.info("version::{}",version);
        log.info("test::{}",test);
        log.info("username::{}",userConfig.getName());
        log.info("prov::{}",userConfig.getProv());
        log.info("address.prov::{}",addressConfig.getProv());
        log.info("address.city::{}",addressConfig.getCity());
        log.info("address.county::{}",addressConfig.getCounty());
        return "success";
    }
}
