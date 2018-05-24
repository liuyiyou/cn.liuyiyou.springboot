package cn.liuyiyou.spring;

import cn.liuyiyou.spring.propertysource.DataSourceConfig;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

@Configuration
@Configurable
@ComponentScan(basePackages = "cn.liuyiyou.spring")
@PropertySource(value = "classpath:datasource.properties")
public class AppConfig {


    /**
     * 这个不需要PropertySource注解
     * @return
     */
    @Bean
    public PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
        PropertyPlaceholderConfigurer propertyPlaceholderConfigurer = new PropertyPlaceholderConfigurer();
         propertyPlaceholderConfigurer.setLocation(new ClassPathResource("datasource.properties"));
        return propertyPlaceholderConfigurer;
    }

    @Bean
    public PropertySourcesPlaceholderConfigurer propertyConfig() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public DataSourceConfig dataSourceConfig() {
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        return dataSourceConfig;
    }
}
