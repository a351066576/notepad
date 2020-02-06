package com.m.notepad.service;

import com.m.notepad.domain.Note;
import com.m.notepad.domain.SysLog;

import java.util.List;
import java.util.Map;

/**
 * @author 酸辣粉
 * @description
 * @date 2020/2/2
 */
public interface SysLogService {

    /**
     * 分页查询
     * @param params
     * @return
     */
    List<SysLog> querySysLogList(Map<String, Object> params);

    /**
     * 查询总数
     * @return
     */
    Integer count();

}
