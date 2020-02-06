package com.m.notepad.service.serviceImpl;

import com.m.notepad.dao.SysLogDao;
import com.m.notepad.domain.SysLog;
import com.m.notepad.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 酸辣粉
 * @description
 * @date 2020/2/2
 */
@Service
public class SysLogServiceImpl implements SysLogService {

    @Autowired
    SysLogDao sysLogDao;

    @Override
    public List<SysLog> querySysLogList(Map<String, Object> params) {
        return sysLogDao.querySysLogList(params);
    }

    @Override
    public Integer count() {
        return sysLogDao.count();
    }
}
