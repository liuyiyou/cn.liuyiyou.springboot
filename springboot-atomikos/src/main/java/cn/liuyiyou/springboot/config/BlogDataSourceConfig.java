package com.ibalife.message.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * User: liuyiyou
 * Date: 2017/9/9
 * Time: 下午8:10
 */

@Configuration
@MapperScan(basePackages = BlogDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "blogSqlSessionFactory")
public class BlogDataSourceConfig {



    static final String PACKAGE = "com.ibalife.message.mapper.blog";
    static final String MAPPER_LOCATION = "classpath:mapper/blog/*.xml";

    @Bean(name = "blogDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.blog")
    @Primary
    public DataSource testDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "blogTransactionManager")
    @Primary
    public DataSourceTransactionManager clusterTransactionManager(@Qualifier("blogDataSource") DataSource dataSource) {
        System.out.println(">>>>>>>blogTransactionManager");
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "blogSqlSessionFactory")
    @Primary
    public SqlSessionFactory clusterSqlSessionFactory(@Qualifier("blogDataSource") DataSource clusterDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(clusterDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(BlogDataSourceConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }
}
