package com.wu.controller;

import com.wu.pojo.DevUser;
import com.wu.service.dev.DevUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class DevLoginController {
    @Resource
    private DevUserService devUserService;


    @RequestMapping(value = "/devLogin.html")
    public String login(){
        return "/dev/devlogin";
    }

    @RequestMapping(value = "/doLogin.html")
    public String doLogin(@RequestParam(value = "devCode") String devCode,
                          @RequestParam(value = "devPassword") String devPassword,
                          HttpServletRequest request, HttpSession session){
        if (devCode!=null&&devPassword!=null){
            DevUser devUser = devUserService.findOneDevUser(devCode, devPassword);
            if (devUser!=null){
                //重定向到主页面
                session.setAttribute("devUser",devUser);
                return "redirect:/dev/devMain.html";
            }else {
                request.setAttribute("msg","账号或密码不正确！");
                return "/dev/devlogin";
            }
        }else {
            request.setAttribute("msg","账号或密码不能为空！");
            return "/dev/devlogin";
        }
    }
}
