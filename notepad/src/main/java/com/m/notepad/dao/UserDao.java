package com.m.notepad.dao;


import com.m.notepad.domain.Role;
import com.m.notepad.domain.User;
import com.m.notepad.sql.UserSql;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author 酸辣粉
 * @description
 * @date 2020/1/23
 */
@Mapper
public interface UserDao {

    /**
     *根据用户id关联用户的所有权限
     * @param id
     * @return List<Role>
     */
    @Select("select * from tb_role r , tb_user_role ur where r.id = ur.role_id and user_id = #{id}")
    List<Role> findRoleByUser(Integer id);

    /**
     * 根据登录名和密码查询用户信息，同时关联查询用户的权限
     * @param userName
     * @return User
     */
    @Select("select * from tb_user where user_name = #{userName}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "name",property = "name"),
            @Result(column = "user_name",property = "userName"),
            @Result(column = "password",property = "password"),
            @Result(column = "creat_time",property = "creatTime"),
            @Result(column = "id",property = "roles",many = @Many(select = "findRoleByUser"))

    })
    User findUser(@Param(value = "userName") String userName);

    /**
     * 修改用户密码
     * @param password
     * @return Integer
     */
    @Update("update tb_user set password = #{password} where user_name = #{userName}")
    Integer modifyUser(@Param(value = "userName") String loginName,@Param(value = "password") String password);

    /**
     * 添加用户
     * @param user
     * @return Integer
     */
    @InsertProvider(type = UserSql.class,method = "registerUser")
    Integer registerUser(User user);

    /**
     * 通过用户名查找用户id
     * @param userName
     * @return
     */
    @Select("select id from tb_user where user_name = #{userName}")
    Integer findUserIdByUserName(@Param(value = "userName") String userName);


}
