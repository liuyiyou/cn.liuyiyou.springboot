package cn.liuyiyou.springboot.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class HelloApplication {

    public static ConfigurableApplicationContext applicationContext;

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(HelloApplication.class, args);
        applicationContext = run;
      //  printlnBeanNames();
    }

    private static void printlnBeanNames() {
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        Arrays.asList(beanDefinitionNames).forEach(System.out::println);
    }


}
