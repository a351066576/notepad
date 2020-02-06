package com.m.notepad.sql;

import com.m.notepad.domain.User;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 * @author 酸辣粉
 * @description
 * @date 2020/1/31
 */
public class NoteSql {

    /**
     * 分页查询
     * @param params
     * @return
     */
    public String queryNoteList(Map<String, Object> params){
        return new SQL(){{
            SELECT("*");
            FROM("tb_note n,tb_user u");
            if(params.get("userName")!=null){
                WHERE("n.user_id = u.id");
                WHERE("u.user_name = #{userName}");
            }
            if(params.get("title")!=null){
                WHERE("n.title = #{title}");
            }
            if(params.get("offset")!=null&&params.get("limit")!=null){
                LIMIT("#{offset},#{limit}");
            }
            ORDER_BY("n.creat_time DESC");
        }}.toString();
    }

    /**
     * 查询总数
     * @param params
     * @return
     */
    public String count(Map<String, Object> params){
        return new SQL(){{
            SELECT("count(*)");
            FROM("tb_note n,tb_user u");
            if(params.get("userName")!=null){
                WHERE("n.user_id = u.id");
                WHERE("u.user_name = #{userName}");
            }
            if(params.get("title")!=null){
                WHERE("n.title like #{title}");
            }
        }}.toString();
    }

    /**
     * 查询日记
     * @param params
     * @return
     */
    public String queryNote(Map<String, Object> params){
        return new SQL(){{
            SELECT("*");
            FROM("tb_note n,tb_user u");
            if(params.get("userName")!=null){
                WHERE("n.user_id = u.id");
                WHERE("u.user_name = #{userName}");
            }
            if(params.get("id")!=null){
                WHERE("n.id = #{id}");
            }
        }}.toString();
    }

    public String insertNote(Map<String, Object> params){
        return new SQL(){{
            INSERT_INTO("tb_note");
            if(params.get("userId")!=null){
                VALUES("user_id","#{userId}");
            }
            if(params.get("title")!=null){
                VALUES("title","#{title}");
            }
            if(params.get("content")!=null){
                VALUES("content","#{content}");
            }
            if(params.get("creatTime")!=null){
                VALUES("creat_time","#{creatTime}");
            }
            if(params.get("lastModifiedTime")!=null){
                VALUES("last_modified_time","#{lastModifiedTime}");
            }
        }}.toString();
    }

    public String updateNote(Map<String, Object> params){
        return new SQL(){{
            UPDATE("tb_note");
            if(params.get("title")!=null){
                SET("title=#{title}");
            }
            if(params.get("content")!=null){
                SET("content=#{content}");
            }
            if(params.get("lastModifiedTime")!=null){
                SET("last_modified_time = #{lastModifiedTime}");
            }
            WHERE("id = #{id}");
            WHERE("user_id = #{userId}");
        }}.toString();
    }

    public String deleteNote(Map<String, Object> params){
        return new SQL(){{
            DELETE_FROM("tb_note");
            if(params.get("id")!=null){
                WHERE("id = #{id}");
            }
            if(params.get("userId")!=null){
                WHERE("user_id = #{id}");
            }
        }}.toString();
    }


}
