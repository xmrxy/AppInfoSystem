package com.wu.controller.appVersionController;

import com.wu.pojo.AppVersion;
import com.wu.service.appVersion.AppVersionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value = "/appVersion")
public class AppVersionController {

    @Resource
    private AppVersionService appVersionService;

    @RequestMapping(value = "/addVersion.html/{appinfoid}")
    public String addVersion(@PathVariable Integer appinfoid,Model model){
        List<AppVersion> versionList = appVersionService.findAppVersionList(appinfoid);
        model.addAttribute("appVersionList",versionList);
        return "/dev/appversionadd";
    }

}
