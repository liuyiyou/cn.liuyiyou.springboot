package cn.liuyiyou.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/***
 *
 * @author: liuyiyou.cn
 * @date: 2018/8/30
 * @Copyright 2018 liuyiyou.cn Inc. All rights reserved
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().anyRequest().permitAll();

        http.formLogin()// 跳转到登陆页面
                .and()
                .authorizeRequests()//定义哪些Url需要被保护，哪些不需要被保护
                .anyRequest() //任何请求，登陆后可以访问
                .authenticated();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
