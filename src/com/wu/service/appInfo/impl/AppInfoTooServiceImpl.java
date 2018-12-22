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

    @Override
    public int updateAppInfoVersion(Integer appId, Integer versionId) {
        return appInfoTooMapper.updateAppInfoVersion(appId,versionId);
    }

    @Override
    public int updateAppStatus(Integer appId, Integer appStatus) {
        return appInfoTooMapper.updateAppStatus(appId,appStatus);
    }

    @Override
    public AppInfoToo findAppInfoById(Integer appId) {
        return appInfoTooMapper.getAppInfoById(appId);
    }

    @Override
    public int updateAppInfo(AppInfoToo appInfoToo) {
        return appInfoTooMapper.updateAppInfo(appInfoToo);
    }

    @Override
    public int delApp(Integer appId) {
        return appInfoTooMapper.delApp(appId);
    }

    @Override
    public int delAppPicture(Integer appId) {
        return appInfoTooMapper.delAppPicture(appId);
    }

    @Override
    public int checkApp(Integer appId, Integer status) {
        return appInfoTooMapper.checkApp(appId,status);
    }

    @Override
    public int downLoadAppVersion(Integer appId, Integer downloads) {
        return appInfoTooMapper.downLoadAppVersion(appId,downloads);
    }
}
