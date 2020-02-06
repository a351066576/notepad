package com.m.notepad.security;

import com.m.notepad.dao.UserDao;
import com.m.notepad.domain.Role;
import com.m.notepad.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 酸辣粉
 * @description
 * @date 2020/1/30
 */
@Configuration
public class MyUserDetailService implements UserDetailsService{

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //模拟一个用户
        User user = userDao.findUser(s);
        if(user==null){
            throw new UsernameNotFoundException("用户名不存在或密码错误");
        }

        //创建集合用来保存权限,GrantedAuthority对象代表赋予当前角色的权限
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        //创建集合获取用户权限
        List<Role> roles = user.getRoles();
        for(Role role : roles){
            //将关联对象Role的authoritie属性保存为用户认证的权限
            authorities.add(new SimpleGrantedAuthority(role.getAuthority()));

        }
        return new org.springframework.security.core.userdetails.User(
                s,
                user.getPassword(),
                authorities);
    }
}
