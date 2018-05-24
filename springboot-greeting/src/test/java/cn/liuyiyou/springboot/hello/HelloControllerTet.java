package cn.liuyiyou.springboot.hello;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.web.client.RestTemplate;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

/***
 * @author: liuyiyou
 * @date: 2018/5/23
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloControllerTet {

    @Test
    public void hello() {
        RestTemplate restTemplate = new RestTemplate();

        MockRestServiceServer mockServer =
                MockRestServiceServer.bindTo(restTemplate).build();
        mockServer.expect(requestTo("/hello"))
                .andRespond(withSuccess());

// Test code that uses the above RestTemplate ...

        mockServer.verify();
    }
}
