package cn.liuyiyou.springboot.redis;

import cn.liuyiyou.springboot.mybatis.AbstractTest;
import cn.liuyiyou.springboot.service.IUserService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * User: liuyiyou
 * Date: 2017/9/9
 * Time: 下午2:28
 */
public class RedisTest extends AbstractTest {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private IUserService userService;

    @Autowired
    private RedisTemplate redisTemplate;


    @Test
    public void getRgetRedisUserByIdTest() {
        userService.getRedisUserById(1L);
    }

    @Test
    public void redisTest() {
        boolean result = redisTemplate.hasKey("name");
        logger.info("result::{}", result);
    }

}
