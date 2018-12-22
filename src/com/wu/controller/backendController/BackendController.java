package com.wu.controller.backendController;

import com.wu.pojo.AppInfoToo;
import com.wu.pojo.AppVersion;
import com.wu.service.appInfo.AppInfoService;
import com.wu.service.appInfo.AppInfoTooService;
import com.wu.service.appVersion.AppVersionService;
import com.wu.service.backend.BackendUserService;
import com.wu.util.PageBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "/backend")
public class BackendController {

    @Resource
    private AppInfoService appInfoService;

    @Resource
    private AppVersionService appVersionService;

    @Resource
    private AppInfoTooService appInfoTooService;


    private PageBean<AppInfoToo> pageBean = new PageBean<AppInfoToo>();


    @RequestMapping(value = "/backendMain.html")
    public String devMain() {
        return "/backend/BackendMain";
    }

    @RequestMapping(value = "/backendLogOut.html")
    public String logOut(HttpSession session) {
        session.invalidate();
        return "redirect:/backendLogin.html";
    }

    @RequestMapping(value = "/appList.html")
    public String appList(@RequestParam(value = "softwareName", required = false) String softwareName,
                          @RequestParam(value = "APKName", required = false) String APKName,
                          @RequestParam(value = "softwareSize", required = false) Double softwareSize,
                          @RequestParam(value = "valueNamePingTai", required = false) Integer valueNamePingTai,
                          @RequestParam(value = "categoryName1", required = false) Integer categoryName1,
                          @RequestParam(value = "categoryName2", required = false) Integer categoryName2,
                          @RequestParam(value = "categoryName3", required = false) Integer categoryName3,
                          @RequestParam(value = "valueNameStatus", required = false) Integer valueNameStatus,
                          @RequestParam(value = "downloads", required = false) Integer downloads,
                          @RequestParam(value = "versionId", required = false) Integer versionId,
                          @RequestParam(value = "pageSize", required = false) Integer pageSize,
                          @RequestParam(value = "pageIndex", required = false) Integer pageIndex,
                          Model model) {

        if (pageSize == null) {
            pageSize = 5;
        }
        if (pageIndex == null) {
            pageIndex = 1;
        }
        //获取总量
        int count = appInfoService.findAppInfoCount(softwareName, APKName, softwareSize,
                valueNamePingTai, categoryName1, categoryName2, categoryName3,
                valueNameStatus, downloads, versionId);
        //设置当前页码
        pageBean.setPageIndex(pageIndex);
        //设置总数量
        pageBean.setTotalCount(count);
        //设置页面容量
        pageBean.setPageSize(pageSize);
        //设置初始行数
        int startRow = pageBean.getStartRow(pageBean.getPageIndex());
        //获得信息
        List<AppInfoToo> appInfoList = appInfoService.findAppInfo(softwareName, APKName, softwareSize,
                valueNamePingTai, categoryName1, categoryName2, categoryName3,
                valueNameStatus, downloads, versionId, startRow, pageBean.getPageSize());
        pageBean.setList(appInfoList);
        model.addAttribute("appPageBean", pageBean);
        return "backend/applist";
    }

    @RequestMapping(value = "checkApp.html/{appId}/{versionId}")
    public String checkApp(@PathVariable Integer appId,
                           @PathVariable Integer versionId, Model model) {
        AppInfoToo appInfo = appInfoTooService.findAppInfoById(appId);
        AppVersion appVersion = appVersionService.findOneAppVersionByVersionId(versionId);
        model.addAttribute("appInfo", appInfo);
        model.addAttribute("appVersion", appVersion);
        return "/backend/appcheck";
    }


    @RequestMapping(value = "doCheckApp.html")
    public String doCheckApp(@RequestParam(value = "appId")Integer appId,
                             @RequestParam(value = "status")String status,Model model){
        if ("2".equals(status)){
            //通过审核
            int i = appInfoTooService.checkApp(appId, 2);
            if (i>0){
                return "redirect:/backend/appList.html";
            }
        }else if ("3".equals(status)){
            //不同过审核
            model.addAttribute("msg","审核不通过");
            return "/backend/applist";
        }
        return null;
    }
}
