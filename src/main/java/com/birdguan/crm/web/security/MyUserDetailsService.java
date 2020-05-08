package com.birdguan.crm.web.security;

import com.birdguan.crm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Configuration
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;
    /**
     * 用户认证
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 1. 根据用户名从数据库查找有没有这个用户信息
        com.birdguan.crm.model.User dbUser = userService.findByUsername(username);
        if (dbUser == null) return null;
        // 2. 如果有用户信息，返回一个User对象
        String pwd = passwordEncoder.encode(dbUser.getPassword());
        return new User(username,
                pwd, //密码是从数据库获取，需要加密器进行加密
                getCurrentUserAuthorities());
    }

    /**
     * 获取当前用户拥有的权限
     * @return
     */
    public Collection<? extends GrantedAuthority> getCurrentUserAuthorities() {
        List<GrantedAuthority> list = new ArrayList<>();
        list.add(new SimpleGrantedAuthority("COURSEORDER_READ"));
        list.add(new SimpleGrantedAuthority("COURSEORDER_DELETE"));
        list.add(new SimpleGrantedAuthority("COURSEORDER_ADD"));
        list.add(new SimpleGrantedAuthority("COURSEORDER_EDIT"));
        list.add(new SimpleGrantedAuthority("COURSEORDER_SAVE"));
        return list;
    }
}
