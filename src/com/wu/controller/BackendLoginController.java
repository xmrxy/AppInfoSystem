package com.wu.controller;

import com.wu.pojo.BackendUser;
import com.wu.pojo.DataDictionary;
import com.wu.service.backend.BackendUserService;
import com.wu.service.dataDictionary.DataDictionaryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class BackendLoginController {
    @Resource
    private BackendUserService backendUserService;

    @Resource
    private DataDictionaryService dataDictionaryService;


    @RequestMapping(value = "/backendLogin.html")
    public String login(){
        return "/backend/backendlogin";
    }



    @RequestMapping(value = "/backendDoLogin.html")
    public String doLogin(@RequestParam(value = "userCode") String userCode,
                          @RequestParam(value = "userPassword") String userPassword,
                          HttpServletRequest request, HttpSession session){
        if (userCode!=null&&userPassword!=null){
            BackendUser backendUser = backendUserService.fingOneBackendUser(userCode,userPassword);
            DataDictionary dictionary = dataDictionaryService.findOneDictionary(backendUser.getUserType());
            if (backendUser!=null){
                //重定向到主页面
                session.setAttribute("backendUser",backendUser);
                session.setAttribute("dictionary",dictionary);
                return "redirect:/backend/backendMain.html";
            }else {
                request.setAttribute("msg","账号或密码不正确！");
                return "/backend/backendlogin";
            }
        }else {
            request.setAttribute("msg","账号或密码不能为空！");
            return "/backend/backendlogin";
        }
    }
}
