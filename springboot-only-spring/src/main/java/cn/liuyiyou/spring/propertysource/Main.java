package cn.liuyiyou.spring.propertysource;

import cn.liuyiyou.spring.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.refresh();
        DataSourceConfig config = ctx.getBean(DataSourceConfig.class);
        System.out.println(config.getUrl());
        System.out.println(config.getDriverClassName());
    }
}
