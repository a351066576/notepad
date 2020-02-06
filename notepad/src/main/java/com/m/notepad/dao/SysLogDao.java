package com.m.notepad.dao;

import com.m.notepad.domain.Note;
import com.m.notepad.domain.SysLog;
import com.m.notepad.sql.NoteSql;
import com.m.notepad.sql.SysLogSql;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @author 酸辣粉
 * @description 系统日志dao
 * @date 2020/2/2
 */

@Mapper
public interface SysLogDao {

    /**
     * 保存日志
     * @param sysLog
     */
    @Insert("insert into sys_log(" +
            "id,user_name,operation,time,method,params,ip,create_time) values(" +
            "#{id},#{userName},#{operation},#{time},#{method},#{params},#{ip},#{createTime})")
    void saveSysLog(SysLog sysLog);

    /**
     * 分页查询
     * @param params
     * @return
     */
    @SelectProvider(type = SysLogSql.class,method = "querySysLogList")
    @ResultType(SysLog.class)
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "user_name",property = "userName"),
            @Result(column = "operation",property = "operation"),
            @Result(column = "time",property = "time"),
            @Result(column = "method",property = "method"),
            @Result(column = "params",property = "params"),
            @Result(column = "ip",property = "ip"),
            @Result(column = "create_time",property = "createTime")

    })
    List<SysLog> querySysLogList(Map<String, Object> params);

    /**
     * 查询总数
     * @return
     */
    @Select("select count(*) from sys_log")
    @ResultType(Integer.class)
    Integer count();


}
