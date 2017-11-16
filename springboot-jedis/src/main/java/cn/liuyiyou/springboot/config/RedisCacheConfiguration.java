package cn.liuyiyou.springboot.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * User: liuyiyou
 * Date: 2017/9/11
 * Time: 下午4:33
 */
@Configuration
@EnableCaching
@EnableAutoConfiguration
public class RedisCacheConfiguration extends CachingConfigurerSupport {
    Logger logger = LoggerFactory.getLogger(RedisCacheConfiguration.class);


    @Value("${spring.redis.host}")
    String host;

    @Bean
    @ConfigurationProperties("spring.redis")
    public  JedisPoolConfig config(){
        JedisPoolConfig config = new JedisPoolConfig();
        return config;
    }

    @Bean
    @ConfigurationProperties("spring.redis")
    public JedisPool redisPoolFactory() {
        JedisPool jedisPool = new JedisPool(config(),host);
        return jedisPool;
    }
}
