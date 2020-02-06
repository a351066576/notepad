package com.m.notepad.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 酸辣粉
 * @description
 * @date 2020/2/1
 */
public class DateUtil {
    public String Test2(Date time){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String timeFormat = sdf.format(time);
        System.out.println(timeFormat);
        return timeFormat;
    }
}
