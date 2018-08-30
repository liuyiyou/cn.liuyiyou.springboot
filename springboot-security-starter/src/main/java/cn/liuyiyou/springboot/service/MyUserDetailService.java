package cn.liuyiyou.springboot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/***
 *
 * @author: liuyiyou.cn
 * @date: 2018/8/30
 * @Copyright 2018 liuyiyou.cn Inc. All rights reserved
 */
@Component
public class MyUserDetailService implements UserDetailsService {

    private Logger log = LoggerFactory.getLogger(MyUserDetailService.class);

    @Autowired
    private PasswordEncoder passwordEncoder;


    /**
     * 登陆的时候会调用该方法
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("username::{}",username);
        log.info("passwordEncode::{}",passwordEncoder.encode("123456"));
        UserDetails user = User.builder()
                .username(username)
                .password(passwordEncoder.encode("123456"))
                .authorities("admin").build();
        return user;
    }
}
