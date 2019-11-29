package cn.liuyiyou.springboot;

import cn.liuyiyou.springboot.dubbo.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Spring Boot 应用启动类
 * <p>
 * Created by liuyiyou.cn on 16/4/26.
 */
// Spring Boot 应用的标识
@SpringBootApplication
@Slf4j
public class ClientApplication {


    @Reference(version = "1.0.0", url = "dubbo://127.0.0.1:12345")
    private DemoService demoService;

    public static void main(String[] args) {
//        // 程序启动入口
//        // 启动嵌入式的 Tomcat 并初始化 Spring 环境及其各 Spring 组件
//        ConfigurableApplicationContext run = SpringApplication.run(ClientApplication.class, args);
//        CityDubboConsumerService cityService = run.getBean(CityDubboConsumerService.class);
//        cityService.printCity();

        SpringApplication.run(ClientApplication.class).close();
    }

    @Bean
    public ApplicationRunner runner() {
        return args -> log.info(demoService.sayHello("Hello Dubbo"));
    }
}
