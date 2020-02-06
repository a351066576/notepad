package com.m.notepad.controller;

import com.m.notepad.annotation.Log;
import com.m.notepad.domain.SysLog;
import com.m.notepad.service.serviceImpl.SysLogServiceImpl;
import com.m.notepad.utils.PageUtils;
import com.m.notepad.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author 酸辣粉
 * @description
 * @date 2020/2/2
 */

@Controller
@RequestMapping("/syslog")
public class SysLogController {

    @Autowired
    SysLogServiceImpl sysLogService;

    @Log("访问系统日志管理页面")
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping("syslogPage")
    public String syslogPage(){
        return "syslogpage";
    }

    @Log("查询系统日志")
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping("querySysLogList")
    @ResponseBody
    public PageUtils querySysLogList(@RequestParam Map<String, Object> params) {
        Query query = new Query(params);
        List<SysLog> sysLogList = sysLogService.querySysLogList(query);
        int total = sysLogService.count();
        PageUtils pageUtil = new PageUtils(sysLogList, total);
        return pageUtil;
    }

}
