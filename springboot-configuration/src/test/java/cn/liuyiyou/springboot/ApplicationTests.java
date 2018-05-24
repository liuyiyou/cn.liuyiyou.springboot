package cn.liuyiyou.springboot;

import cn.liuyiyou.springboot.config.MessageConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void testGetMessageBean() throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MessageConfiguration.class);
        assertEquals("message configuration", ctx.getBean("message"));
    }

    @Test
    public void testScanPackages() throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.scan("cn.liuyiyou.springboot");
        ctx.refresh();
        assertEquals("message configuration", ctx.getBean("message"));
    }

}
