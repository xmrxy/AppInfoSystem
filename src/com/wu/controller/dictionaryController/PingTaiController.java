package com.wu.controller.dictionaryController;

import com.alibaba.fastjson.JSONObject;
import com.wu.pojo.PingTai;
import com.wu.service.dictionary.PingTaiService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value = "/pingTai")
public class PingTaiController {

    @Resource
    private PingTaiService pingTaiService;

    @RequestMapping(value = "/pingTaiList.json")
    @ResponseBody
    public Object getPingTaiInfo(){
        List<PingTai> pingTaiList = pingTaiService.findPingTaiInfo();
        String json = JSONObject.toJSONString(pingTaiList);
        return json;
    }

}
