package com.wu.service.appVersion.impl;

import com.wu.dao.appVersion.AppVersionMapper;
import com.wu.pojo.AppVersion;
import com.wu.service.appInfo.AppInfoTooService;
import com.wu.service.appVersion.AppVersionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class AppVersionServiceImpl implements AppVersionService {

    @Resource
    private AppVersionMapper appVersionMapper;

    @Override
    public int delApk(Integer versionId) {
        return appVersionMapper.delApk(versionId);
    }

    @Override
    public List<AppVersion> findAppVersionList(Integer appId) {
        return appVersionMapper.AppVersionList(appId);
    }

    @Override
    public int addAppVersion(AppVersion appVersion) {
        return appVersionMapper.addAppVersion(appVersion);
    }

    @Override
    public int updateAppVersion(AppVersion appVersion) {
        return appVersionMapper.updateAppVersion(appVersion);
    }

    @Override
    public AppVersion findOneAppVersionByVersionId(Integer versionId) {
        return appVersionMapper.getOneAppVersionByVersionId(versionId);
    }
}
