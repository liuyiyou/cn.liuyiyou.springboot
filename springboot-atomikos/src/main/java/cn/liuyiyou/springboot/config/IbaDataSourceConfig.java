package com.ibalife.message.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * User: liuyiyou
 * Date: 2017/9/9
 * Time: 下午8:10
 */

@Configuration
@MapperScan(basePackages = IbaDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "ibaSqlsessionFactory")
public class IbaDataSourceConfig {

    static final String PACKAGE = "com.ibalife.message.mapper.iba";
    static final String MAPPER_LOCATION = "classpath:mapper/ibalife/*.xml";


    @Bean(name = "ibaDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.iba")
    public DataSource testDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "ibaTransactionManager")
    public DataSourceTransactionManager clusterTransactionManager(@Qualifier("ibaDataSource") DataSource dataSource) {
        System.out.println(">>>>>>>ibaTransactionManager");
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "ibaSqlsessionFactory")
    public SqlSessionFactory clusterSqlSessionFactory(@Qualifier("ibaDataSource") DataSource clusterDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(clusterDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(IbaDataSourceConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }
}
