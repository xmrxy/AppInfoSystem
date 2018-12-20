package com.wu.service.appVersion.impl;

import com.wu.dao.appVersion.AppVersionMapper;
import com.wu.pojo.AppVersion;
import com.wu.service.appVersion.AppVersionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class AppVersionServiceImpl implements AppVersionService {

    @Resource
    private AppVersionMapper appVersionMapper;

    @Override
    public List<AppVersion> findAppVersionList(Integer appId) {
        return appVersionMapper.AppVersionList(appId);
    }

    @Override
    public int addAppVersion(AppVersion appVersion) {
        return appVersionMapper.addAppVersion(appVersion);
    }
}
