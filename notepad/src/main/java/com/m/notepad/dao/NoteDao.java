package com.m.notepad.dao;

import com.m.notepad.domain.Note;
import com.m.notepad.sql.NoteSql;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @author 酸辣粉
 * @description
 * @date 2020/1/31
 */
@Mapper
public interface NoteDao {

    /**
     * 分页查询
     * @param params
     * @return
     */
    @SelectProvider(type = NoteSql.class,method = "queryNoteList")
    @ResultType(Note.class)
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "title",property = "title"),
            @Result(column = "content",property = "content"),
            @Result(column = "creat_time",property = "creatTime"),
            @Result(column = "last_modified_time",property = "lastModifiedTime")

    })
    List<Note> queryNoteList(Map<String, Object> params);

    /**
     * 查询总数
     * @param params
     * @return
     */
    @SelectProvider(type = NoteSql.class,method = "count")
    @ResultType(Integer.class)
    Integer count(Map<String, Object> params);

    /**
     * 查询单个日记
     * @param params
     * @return
     */
    @SelectProvider(type = NoteSql.class,method = "queryNote")
    @ResultType(Note.class)
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "title",property = "title"),
            @Result(column = "content",property = "content"),
            @Result(column = "creat_time",property = "creatTime"),
            @Result(column = "last_modified_time",property = "lastModifiedTime"),

    })
    Note queryNote(Map<String, Object> params);


    /**
     * 新增日记
     * @param params
     * @return
     */
    @InsertProvider(type = NoteSql.class,method = "insertNote")
    @ResultType(Integer.class)
    Integer insertNote(Map<String, Object> params);

    /**
     * 修改日记
     * @param params
     * @return
     */
    @InsertProvider(type = NoteSql.class,method = "updateNote")
    @ResultType(Integer.class)
    Integer updateNote(Map<String, Object> params);

    /**
     * 删除日记
     * @param params
     * @return
     */
    @InsertProvider(type = NoteSql.class,method = "deleteNote")
    @ResultType(Integer.class)
    Integer deleteNote(Map<String, Object> params);

}
