package com.wu.controller.appVersionController;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.wu.pojo.AppVersion;
import com.wu.service.appVersion.AppVersionService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping(value = "/appVersion")
public class AppVersionController {

    @Resource
    private AppVersionService appVersionService;

    @RequestMapping(value = "/addVersion.html/{appinfoid}")
    public String appVersion(@PathVariable Integer appinfoid,Model model){
        List<AppVersion> versionList = appVersionService.findAppVersionList(appinfoid);
        model.addAttribute("appVersionList",versionList);
        model.addAttribute("appVersion",appinfoid);
        return "/dev/appversionadd";
    }


    @RequestMapping(value = "/doAppVersion.html",method = RequestMethod.POST)
    public String  addAppVersion(AppVersion appVersion,
                                 @RequestParam(value = "a_downloadLink") MultipartFile attach,
                                 HttpServletRequest request){
        //实现文件上传
        if(!attach.isEmpty()){
            //定义上传路径
            String realPath = request.getSession().getServletContext().getRealPath("/statics/uploadFiles/");
            System.out.println("apk上传路径："+realPath);
            //获取文件名
            String oldFileName = attach.getOriginalFilename();
            //获取文件后缀
            String extension = FilenameUtils.getExtension(oldFileName);
            //判断文件大少
            int fileSize=30000000;
            if (attach.getSize()<fileSize){
                //符合文件大少
                if ("apk".equals(extension)){
                    //符合文件格式
                    //创建新的文件
                    File targetFile=new File(realPath,oldFileName);
                    if (!targetFile.exists()){
                        //如果文件没有，则创建
                        targetFile.mkdirs();
                    }
                    try {
                        attach.transferTo(targetFile);
                        appVersion.setApkFileName(oldFileName);
                        appVersion.setApkLocPath(realPath+oldFileName);
                        appVersion.setDownloadLink("/statics/uploadFiles/"+oldFileName);
                    } catch (IOException e) {
                        e.printStackTrace();
                        request.setAttribute("msg","上传失败！");
                        return "/dev/appversionadd";
                    }
                }else{
                    //不符合文件格式
                    request.setAttribute("msg","图片格式不正确，要求是.jpg/.png/.jpeg");
                    return "/dev/appversionadd";
                }
            }else{
                //不符合文件大少
                request.setAttribute("msg","图片大少不符合要求！");
                return "/dev/appversionadd";
            }
        }
        int i = appVersionService.addAppVersion(appVersion);
        if (i>0){
            return "redirect:/appVersion/addVersion.html/"+appVersion.getAppId();
        }else {
            request.setAttribute("msg","添加APP失败");
            return "/dev/appversionadd";
        }
    }

    @RequestMapping(value = "/updateAppVersion.html/{versionid}/{appinfoid}")
    public String updateAppVersion(@PathVariable Integer versionid,
                                   @PathVariable Integer appinfoid,
                                   Model model){
        List<AppVersion> versionList = appVersionService.findAppVersionList(appinfoid);
        model.addAttribute("appVersionList",versionList);
        model.addAttribute("oneAppVersion",versionList.get(0));
        return "/dev/appversionmodify";
    }


    @RequestMapping(value = "/doUpdateAppSersion.html")
    public String doUpdateAppVersion(AppVersion appVersion,Model model){
        //修改代码的编写

        model.addAttribute("msg","修改成功！");
        return "redirect:/appVersion/updateAppVersion.html/"+appVersion.getId()+"/"+appVersion.getAppId();
    }

}
