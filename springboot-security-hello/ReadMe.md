1. 加入spring-boot-starter-security之后，不许额外的配置即可生效，

2. 访问的时候，会有一个默认的登陆页面，用户名为user，密码启动时会在控制台打印

3. 如果不想使security生效，可在配置文件中配置：security.basic.enabled=false，不过2.0.x以上版本，不再适用


```java
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().permitAll();

    }
}
```

4. 如果自定义了UserDetailService
```java
@Component
public class MyUserDetailService implements UserDetailsService {


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails user = User.builder().username(username).password("123456").authorities("admin").build();
        return user;
    }
}
```

最后：参考的是这里的：
https://github.com/spring-projects/spring-security/tree/5.0.7.RELEASE/samples/boot/helloworld

需要加上
```java
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

```

不然报错：There is no PasswordEncoder mapped for the id "null"


再次启动，会报错：Encoded password does not look like BCrypt


需加上 

```java
@Component
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails user = User.builder()
                .username(username)
                .password(passwordEncoder.encode("123456"))
                .authorities("admin").build();
        return user;
    }
}

```

5. 自定义登陆页面

spring security会提供一个默认的登陆页面
