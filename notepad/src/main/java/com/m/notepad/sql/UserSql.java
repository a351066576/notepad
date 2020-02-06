package com.m.notepad.sql;


import com.m.notepad.domain.User;
import org.apache.ibatis.jdbc.SQL;

/**
 * @author 酸辣粉
 * @description
 * @date 2020/1/29
 */
public class UserSql {
    public String registerUser(User user){
        return new SQL(){{
            INSERT_INTO("tb_user");
            if(user.getName()!=null){
                VALUES("name","#{name}");
            }
            if(user.getUserName()!=null){
                VALUES("user_name","#{userName}");
            }
            if(user.getPassword()!=null){
                VALUES("password","#{password}");
            }
            if(user.getCreatTime()!=null){
                VALUES("creat_time","#{creatTime}");
            }
        }}.toString();
    }
}
