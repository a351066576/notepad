package com.m.notepad.sql;

import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 * @author 酸辣粉
 * @description
 * @date 2020/2/2
 */
public class SysLogSql {

    /**
     * 分页查询
     * @param params
     * @return
     */
    public String querySysLogList(Map<String, Object> params){
        return new SQL(){{
            SELECT("*");
            FROM("sys_log");
            if(params.get("offset")!=null&&params.get("limit")!=null){
                LIMIT("#{offset},#{limit}");
            }
            ORDER_BY("create_time DESC");
        }}.toString();
    }

}
