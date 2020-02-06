package com.m.notepad.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

/**
 * @author 酸辣粉
 * @description
 * @date 2020/1/30
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyAuthenticationFailureHandler authenticationFailureHandler;

    @Autowired
    private MyAuthenticationSucessHandler authenticationSucessHandler;

    @Autowired
    private MyAuthenticationAccessDeniedHandler authenticationAccessDeniedHandler;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage("/loginPage")//指定了跳转登录页面的url
                .loginProcessingUrl("/login")//对应登录页面form表单的action="/login"
                .failureUrl("/loginPage?err=true")
                .successHandler(authenticationSucessHandler) // 处理登录成功
//                .failureHandler(authenticationFailureHandler) // 处理登录失败

                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/loginPage")
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true)

                .and()
                .exceptionHandling()
                .accessDeniedHandler(authenticationAccessDeniedHandler)

                .and()
                .authorizeRequests() // 授权配置
                .antMatchers("/loginPage","/login","/registerPage","/register").permitAll()//设置白名单
                .antMatchers("/css/**","/img/**","/js/**","/modules/**").permitAll()//设置白名单
                .antMatchers("/druid/**").permitAll()//设置白名单
                .anyRequest().authenticated() // 所有请求都需要认证

                .and().csrf().disable();
    }


}
