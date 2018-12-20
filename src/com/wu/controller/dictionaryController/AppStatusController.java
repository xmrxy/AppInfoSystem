package com.wu.controller.dictionaryController;

import com.alibaba.fastjson.JSONObject;
import com.wu.pojo.AppStatus;
import com.wu.service.dictionary.AppStatusService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value = "/appStatus")
public class AppStatusController {

    @Resource
    private AppStatusService appStatusService;

    @RequestMapping(value = "/appStatusList.json")
    @ResponseBody
    public Object getAppStatus(){
        List<AppStatus> statusList = appStatusService.findAppStatus();
        String json = JSONObject.toJSONString(statusList);
        return json;
    }
}
