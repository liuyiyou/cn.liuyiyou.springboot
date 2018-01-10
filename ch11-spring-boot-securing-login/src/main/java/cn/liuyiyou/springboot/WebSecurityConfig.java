package cn.liuyiyou.springboot;

/***
 * @author: liuyiyou
 * @date: 2018/1/3
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
//该注解和 @Configuration 注解一起使用, 注解 WebSecurityConfigurer 类型的类，或者
// 利用@EnableWebSecurity 注解继承 WebSecurityConfigurerAdapter的类，这样就构成了 Spring Security 的配置
@EnableWebSecurity

//提供了一种便利的方式去创建 WebSecurityConfigurer的实例，只需要重写 WebSecurityConfigurerAdapter 的方法，即可配置拦截什么URL、设置什么权限等安全控制
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    /**
     * 匹配 "/" 路径，不需要权限即可访问
     * 匹配 "/user" 及其以下所有路径，都需要 "USER" 权限
     * 登录地址为 "/login"，登录成功默认跳转到页面 "/user"
     * 退出登录的地址为 "/logout"，退出成功后跳转到页面 "/login"
     * 默认启用 CSRF
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/user/**").hasRole("USER")
                .and()
                .formLogin().loginPage("/login").defaultSuccessUrl("/user")
                .and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/login");
    }


    /**
     * 在内存中创建一个名为 "anoy" 的用户，密码为 "pwd"，拥有 "USER" 权限
     */
    @Override
    protected void configure(AuthenticationManagerBuilder builder) throws Exception{
        builder
                .inMemoryAuthentication()
                .withUser("anoy").password("pwd").roles("USER");
    }
}