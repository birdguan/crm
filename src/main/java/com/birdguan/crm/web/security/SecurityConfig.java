package com.birdguan.crm.web.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 启动web安全功能
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .headers().
                    frameOptions().sameOrigin().httpStrictTransportSecurity().disable()
                    .and()
                .authorizeRequests()
                    .antMatchers("/courseorder/list", "/courseorder/detail", "/courseorder/listjson")
                        .hasAnyAuthority("COURSEORDER_READ")
                    .antMatchers("/courseorder/add").hasAnyAuthority("COURSEORDER_ADD")
                    .antMatchers("/courseorder/delete").hasAnyAuthority("COURSEORDER_DELETE")
                    .antMatchers("/courseorder/save").hasAnyAuthority("COURSEORDER_SAVE")
                    .antMatchers("/courdeorder/edit").hasAnyAuthority("COURSEORDER_EDIT")
                    .antMatchers("/login", "/css/**", "/js/**", "/layui/**", "echarts/**").permitAll()
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginPage("/login")
                    .failureUrl("/login-error")
                    .permitAll()
                    .and()
                .logout()
                    .permitAll();
    }
}
