package cn.liuyiyou.springboot.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/***
 *
 * @author: liuyiyou.cn
 * @date: 2018/8/30
 * @Copyright 2018 liuyiyou.cn Inc. All rights reserved
 */
@Service
@Slf4j
public class MyUserDetailService implements UserDetailsService {


    @Autowired
    private PasswordEncoder passwordEncoder;


    /**
     * 登陆的时候会调用该方法
     *
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails user = User.builder()
                .username(username)
                .password(passwordEncoder.encode("123456")).roles("admin")
                .authorities("admin").build();
        return user;
    }
}
