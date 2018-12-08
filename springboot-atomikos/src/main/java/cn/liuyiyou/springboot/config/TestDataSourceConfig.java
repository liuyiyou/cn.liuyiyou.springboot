package cn.liuyiyou.springboot.config;


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
@MapperScan(basePackages = TestDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "testSqlSessionFactory")
public class TestDataSourceConfig {

    static final String PACKAGE = "com.ibalife.message.mapper.test";
    static final String MAPPER_LOCATION = "classpath:mapper/test/*.xml";


    @Bean(name = "testDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.test")
    public DataSource testDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "testTransactionManager")
    public DataSourceTransactionManager clusterTransactionManager(@Qualifier("testDataSource") DataSource dataSource) {
        System.out.println(">>>>>>>testTransactionManager");
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "testSqlSessionFactory")
    public SqlSessionFactory clusterSqlSessionFactory(@Qualifier("testDataSource") DataSource clusterDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(clusterDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(TestDataSourceConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }
}
