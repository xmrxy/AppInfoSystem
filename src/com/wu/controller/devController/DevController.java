package com.wu.controller.devController;

import com.alibaba.fastjson.JSONObject;
import com.wu.pojo.AppInfoToo;
import com.wu.service.appInfo.AppInfoService;
import com.wu.service.appInfo.AppInfoTooService;
import com.wu.util.PageBean;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Controller
@RequestMapping(value = "/dev")
public class DevController {
    @Resource
    private AppInfoService appInfoService;

    @Resource
    private AppInfoTooService appInfoTooService;

    private PageBean<AppInfoToo> pageBean=new PageBean<AppInfoToo>();

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
    public String appList(@RequestParam(value = "softwareName",required = false) String softwareName,
            @RequestParam(value = "APKName",required = false)String APKName,
            @RequestParam(value = "softwareSize",required = false)Double softwareSize,
            @RequestParam(value = "valueNamePingTai",required = false)Integer valueNamePingTai,
            @RequestParam(value = "categoryName1",required = false)Integer categoryName1,
            @RequestParam(value = "categoryName2",required = false)Integer categoryName2,
            @RequestParam(value = "categoryName3",required = false)Integer categoryName3,
            @RequestParam(value = "valueNameStatus",required = false)Integer valueNameStatus,
            @RequestParam(value = "downloads",required = false)Integer downloads,
            @RequestParam(value = "versionId",required = false)Integer versionId,
            @RequestParam(value = "pageSize",required = false) Integer pageSize,
            @RequestParam(value = "pageIndex",required = false) Integer pageIndex,
            Model model){

        if (pageSize==null){
            pageSize=5;
        }
        if (pageIndex==null){
            pageIndex=1;
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
        model.addAttribute("appPageBean",pageBean);
        return "dev/appinfolist";
    }

    @RequestMapping(value = "/appAdd.html")
    public String appAdd(){
        return "/dev/appinfoadd";
    }

    @RequestMapping(value = "/doAppAdd.html",method=RequestMethod.POST)
    public String addAppInfoToo(AppInfoToo appInfoToo,
                                @RequestParam(value = "a_logoPicPath") MultipartFile attach,
                                Model model, HttpServletRequest request){
        System.out.println("表单传来的信息"+appInfoToo);
        //实现文件上传
        if(!attach.isEmpty()){
            //定义上传路径
            String realPath = request.getSession().getServletContext().getRealPath("/statics/upload/");
            System.out.println("上传路径："+realPath);
            //获取文件名
            String oldFileName = attach.getOriginalFilename();
            //获取文件后缀
            String extension = FilenameUtils.getExtension(oldFileName);
            //判断文件大少
            int fileSize=3000000;
            if (attach.getSize()<fileSize){
                //符合文件大少
                if ("jpg".equals(extension)||"png".equals(extension)||"jpeg".equals(extension)){
                    //符合文件格式
                    //定义新的文件名
                    String newFileName = System.currentTimeMillis() + new Random().nextInt(1000000) + "."+extension;
                    //创建新的文件
                    File targetFile=new File(realPath,newFileName);
                    if (!targetFile.exists()){
                        //如果文件没有，则创建
                        targetFile.mkdirs();
                    }
                    try {
                        attach.transferTo(targetFile);
                        appInfoToo.setLogoPicPath("/statics/upload/"+newFileName);
                        appInfoToo.setLogoLocPath(realPath+newFileName);
                    } catch (IOException e) {
                        e.printStackTrace();
                        request.setAttribute("msg","上传失败！");
                        return "/dev/appinfoadd";
                    }
                }else{
                    //不符合文件格式
                    request.setAttribute("msg","图片格式不正确，要求是.jpg/.png/.jpeg");
                    return "/dev/appinfoadd";
                }
            }else{
                //不符合文件大少
                request.setAttribute("msg","图片大少不符合要求！");
                return "/dev/appinfoadd";
            }
        }
        int i = appInfoTooService.addAppInfoToo(appInfoToo);
        if (i>0){
            return "redirect:/dev//appList.html";
        }else {
            request.setAttribute("msg","添加APP失败");
            return "/dev/appinfoadd";
        }
    }


    @RequestMapping(value = "/apkExist.json")
    @ResponseBody
    public Object apkExist(@RequestParam(value = "apkName") String apkName){
        String trim = apkName.trim();
        Map<Object,String> map=new HashMap<>();
        if (apkName==null||"".equals(trim)){
            map.put("APKName","empty");
            return JSONObject.toJSONString(map);
        }
        int count = appInfoTooService.getOneAppInfoTooCount(apkName);

        if (count>0){
            map.put("APKName","exist");
            return JSONObject.toJSONString(map);
        }else{
            map.put("APKName","noexist");
            return JSONObject.toJSONString(map);
        }
    }



}
