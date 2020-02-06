package com.m.notepad.dao;


import com.m.notepad.domain.Role;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author 酸辣粉
 * @description
 * @date 2020/1/29
 */
@Mapper
public interface RoleDao {

    /**
     * 添加权限
     * @param role
     * @return
     */
    @Insert("insert into tb_role(role) values(#{role})")
    Integer addRole(@Param(value = "role") String role);

    /**
     * 为用户关联权限
     * @param userId
     * @param roleId
     * @return
     */
    @Insert("insert into tb_user_role(user_id,role_id) values(#{userId},#{roleId})")
    Integer addUserRole(@Param(value = "userId") Integer userId, @Param(value = "roleId") Integer roleId);

}
