package cn.liuyiyou.springboot;

import cn.liuyiyou.springboot.property.HomeProperties;
import cn.liuyiyou.springboot.property.MyProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class PropertiesApplication implements CommandLineRunner {

    @Autowired
    private HomeProperties homeProperties;

    public static void main(String[] args) {
        // 程序启动入口
        // 启动嵌入式的 Tomcat 并初始化 Spring 环境及其各 Spring 组件
        SpringApplication.run(PropertiesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("\n" + homeProperties.toString());
        System.out.println();
    }

    @Bean
    @ConfigurationProperties(prefix = "lyy")
    public MyProperties myProperties(){
        return new MyProperties();
    }
}
