package com.m.notepad.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 酸辣粉
 * @description 自定义异常处理
 * @date 2020/2/2
 */

@ControllerAdvice
public class BaseController {

    @ExceptionHandler(value = Exception.class)
    public String defaultErrorHandler(Model model,HttpServletRequest request, Exception e)throws Exception{
        model.addAttribute("message",e.getMessage());
        model.addAttribute("url",request.getRequestURL());
        System.out.println("------------------------------"+e.getMessage());
        return "err";
    }

}
