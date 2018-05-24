package cn.liuyiyou.springboot;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@SpringBootApplication
@EnableTransactionManagement
public class Application {

    private Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Bean
    public Object getTransactionManager(PlatformTransactionManager platformTransactionManager) {
        logger.info(">>>>>>>>>>" + platformTransactionManager.getClass().getName());
        return new Object();
    }

    @Primary
    @Bean(name = "blogDataSource")
    @ConfigurationProperties(prefix = "spring.jta.atomikos.datasource.one")
    public DataSource blogDataSource() {
        return new AtomikosDataSourceBean();
    }

    @Bean(name = "testDataSource")
    @ConfigurationProperties(prefix = "spring.jta.atomikos.datasource.two")
    public DataSource testDataSource() {
        return new AtomikosDataSourceBean();
    }

    @Bean(name = "ibaDataSource")
    @ConfigurationProperties(prefix = "spring.jta.atomikos.datasource.three")
    public DataSource ibatDataSource() {
        return new AtomikosDataSourceBean();
    }

}
