package cn.liuyiyou.springboot.web;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Spring Boot HelloWorldController 测试 - {@link HelloRestController}
 *
 * Created by liuyiyou.cn on 17/09/27.
 */
public class HelloWorldControllerTest {

    @Test
    public void testSayHello() {
        assertEquals("Hello,World!",new HelloRestController().sayHello());
    }
}
