package com.birdguan.crm.web.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    /**
     * 用户认证
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 1. 根据用户名从数据库查找有没有这个用户信息

        // 2. 如果有用户信息，返回一个User对象
        String pwd = passwordEncoder.encode("123456");
        return new User(username,
                pwd, //密码是从数据库获取，需要加密器进行加密
                AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER"));
    }
}
