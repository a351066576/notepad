package com.m.notepad.service;

import com.m.notepad.domain.Role;

import java.util.List;

/**
 * @author 酸辣粉
 * @description
 * @date 2020/1/30
 */
public interface UserService {

    /**
     * 修改用户密码
     * @param userName
     * @param oldPassword
     * @param newPssword
     * @return
     */
    Boolean modifyUser(String userName, String oldPassword, String newPssword);

    /**
     * 添加用户
     * @param name
     * @param userName
     * @param password
     * @return
     */
    Boolean registerUser(String name,String userName,String password);

    /**
     *根据用户id关联用户的所有权限
     * @return List<Role>
     */
    List<Role> findRoleByUser();


}
