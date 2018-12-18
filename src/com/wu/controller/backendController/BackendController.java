package com.wu.controller.backendController;

import com.wu.service.backend.BackendUserService;
import com.wu.service.dataDictionary.DataDictionaryService;
import com.wu.service.dev.DevUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/backend")
public class BackendController {
    @Resource
    private BackendUserService backendUserService;


    @RequestMapping(value = "/backendMain.html")
    public String devMain(){
        return "/backend/BackendMain";
    }

    @RequestMapping(value = "/backendLogOut.html")
    public String logOut(HttpSession session){
            session.invalidate();
            return "redirect:/backendLogin.html";
    }

}
