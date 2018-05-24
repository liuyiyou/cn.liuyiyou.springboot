package cn.liuyiyou.springboot;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LogbackApplicationTests {

    @Rule
    public OutputCapture outputCapture = new OutputCapture();

    @Test
    public void testLoadedCustomLogbackConfig() throws Exception {
        LogbackApplication.main(new String[0]);
        this.outputCapture.expect(containsString("Sample Debug Message"));
        this.outputCapture.expect(not(containsString("Sample Trace Message")));
    }

    @Test
    public void testProfile() throws Exception {
        LogbackApplication
                .main(new String[]{"--spring.profiles.active=staging"});
        this.outputCapture.expect(containsString("Sample Debug Message"));
        this.outputCapture.expect(containsString("Sample Trace Message"));
    }

}
