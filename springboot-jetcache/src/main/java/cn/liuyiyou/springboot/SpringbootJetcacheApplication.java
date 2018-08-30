package cn.liuyiyou.springboot;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableMethodCache(basePackages = "cn.liuyiyou.service")
@EnableCreateCacheAnnotation
public class SpringbootJetcacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJetcacheApplication.class, args);
	}
}
