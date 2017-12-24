package cn.liuyiyou.springboot;

import cn.liuyiyou.springboot.mapper.CityMapper;
import cn.liuyiyou.springboot.model.City;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	private CityMapper cityMapper;

	@Test
	public void addCity(){
		City city = new City();
		city.setId(10L);
		city.setCityName("测试");
		city.setProvinceId(1L);
		city.setDescription("测试jta事务");
		cityMapper.addCity(city);
	}

}
