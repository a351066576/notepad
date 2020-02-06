package com.m.notepad.controller;

import com.m.notepad.annotation.Log;
import com.m.notepad.domain.Role;
import com.m.notepad.service.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author 酸辣粉
 * @description
 * @date 2020/1/30
 */
@Controller
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @Log("访问首页")
    @GetMapping("main")
    public String hello() {
        return "main";
    }

    @Log("访问登录页面")
    @RequestMapping(value = "/loginPage")
    public String loginPige(){
        return "loginpage";
    }

    @Log("访问注册页面")
    @RequestMapping(value = "/registerPage")
    public String registerPage(){
        return "registerpage";
    }

    @Log("访问修改密码页面")
    @RequestMapping(value = "/pswPage")
    public String pswPage(){
        return "pswPage";
    }


    @Log("登录")
    @ResponseBody
    @RequestMapping("/login")
    public void login(@RequestParam String username,@RequestParam String password){
    }

    @Log("退出登录")
    @ResponseBody
    @RequestMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response){

    }

    @Log("注册")
    @RequestMapping("/register")
    public String regist(@RequestParam String name,
                         @RequestParam String username,
                         @RequestParam String password,
                         Model model){
        Boolean flag = userService.registerUser(name, username, password);
        if(!flag){
            model.addAttribute("message","用户名已存在");
            return "registerPage";
        }else{
            model.addAttribute("message","注册成功，请登录");
            return "loginpage";
        }
    }

    @Log("修改密码")
    @RequestMapping("/psw")
    public String psw(@RequestParam String username,
                      @RequestParam String oldPassword,
                      @RequestParam String newPassword,
                      Model model){
        Boolean flag = userService.modifyUser(username,oldPassword,newPassword);
        if(!flag){
            model.addAttribute("message","旧密码不正确");
            return "pswPage";
        }else{
            model.addAttribute("message","修改成功，请登录");
            return "loginpage";
        }
    }

    /**
     * 查看当前用户权限
     * @return
     */
    @Log("查看当前用户权限")
    @RequestMapping("getRoles")
    @ResponseBody
    public List<Role> getRoles(){
        return userService.findRoleByUser();
    }

    @RequestMapping("testerr")
    public void testerr() throws Exception{
        throw new Exception("用户不存在");
    }

}
