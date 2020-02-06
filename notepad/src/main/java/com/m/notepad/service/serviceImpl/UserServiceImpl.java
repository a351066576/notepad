package com.m.notepad.service.serviceImpl;

import com.m.notepad.dao.RoleDao;
import com.m.notepad.dao.UserDao;
import com.m.notepad.domain.Role;
import com.m.notepad.domain.User;
import com.m.notepad.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 酸辣粉
 * @description
 * @date 2020/1/30
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;
    @Autowired
    RoleDao roleDao;
    //注入加密接口
    @Autowired
    private PasswordEncoder passwordEncoder;


    /**
     * 修改密码
     * @param userName
     * @param oldPassword
     * @param newPassword
     * @return
     */
    @Override
    public Boolean modifyUser(String userName, String oldPassword, String newPassword) {
        User user = userDao.findUser(userName);
        //将数据库中的密码和前端输入的旧密码进行加密对比
        boolean flg = passwordEncoder.matches(oldPassword, user.getPassword());
        if(!flg){
            return false;
        }
        //将前端输入的新密码进行加密
        String newPassword_encode = passwordEncoder.encode(newPassword);
        userDao.modifyUser(userName,newPassword_encode);
        return true;
    }


    /**
     * 注册
     * @param name
     * @param userName
     * @param password
     * @return
     */
    @Override
    @Transactional
    public Boolean registerUser(String name,String userName,String password) {
        String password_encode = passwordEncoder.encode(password);
        User user = new User();
        user.setName(name);
        user.setUserName(userName);
        user.setPassword(password_encode);
        user.setCreatTime(new Date());
        //查找用户名是否存在
        Integer id = userDao.findUserIdByUserName(userName);
        if(id!=null){
            return false;
        }
        userDao.registerUser(user);
        Integer userId = userDao.findUserIdByUserName(userName);
        Integer result = roleDao.addUserRole(userId, Role.ROLE_USER);
        System.out.println(result);
        if(result>=1){
            return true;
        }
        return false;
    }

    @Override
    public List<Role> findRoleByUser() {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        Integer userId = userDao.findUserIdByUserName(userName);
        return userDao.findRoleByUser(userId);
    }
}
