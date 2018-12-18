package com.wu.controller.devController;

import com.wu.service.dev.DevUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/dev")
public class DevController {
    @Resource
    private DevUserService devUserService;

    @RequestMapping(value = "/devMain.html")
    public String devMain(){
        return "/dev/DevMain";
    }

    @RequestMapping(value = "/devLogOut.html")
    public String logOut(HttpSession session){
            session.invalidate();
            return "redirect:/devLogin.html";
    }

    @RequestMapping(value = "/appList.html")
    public String appList(){
        return "/dev/appinfolist";
    }

}
