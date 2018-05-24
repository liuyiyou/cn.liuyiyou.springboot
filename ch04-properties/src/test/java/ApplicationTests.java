import cn.liuyiyou.springboot.property.AddressProperties;
import cn.liuyiyou.springboot.property.UserProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/***
 * @author: liuyiyou
 * @date: 2018/3/17
 */
//@RunWith(SpringJUnit4ClassRunner.class)
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    private AddressProperties addressProperties;

    @Autowired
    private UserProperties userProperties;

    @Test
    public void test(){
        System.out.println(addressProperties.getProv());
    }


    @Test
    public void test2(){
        System.out.println(userProperties.getId());
    }


    @Test
    public void contextLoads() {
    }
}
