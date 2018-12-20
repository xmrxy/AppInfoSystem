package com.wu.service.appInfo.impl;

import com.wu.dao.appInfo.AppInfoTooMapper;
import com.wu.pojo.AppInfoToo;
import com.wu.service.appInfo.AppInfoTooService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AppInfoTooServiceImpl implements AppInfoTooService {

    @Resource
    private AppInfoTooMapper appInfoTooMapper;

    @Override
    public int addAppInfoToo(AppInfoToo appInfoToo) {
        return appInfoTooMapper.addAppInfoToo(appInfoToo);
    }

    @Override
    public int getOneAppInfoTooCount(String APKName) {
        return appInfoTooMapper.getOneAppInfoTooCount(APKName);
    }
}
