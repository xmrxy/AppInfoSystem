package com.wu.service.appVersion;

import com.wu.pojo.AppVersion;

import java.util.List;

public interface AppVersionService {

    /**
     * 根据appid查询app版本信息
     * @param appId
     * @return
     */
   List<AppVersion> findAppVersionList(Integer appId);

    /**
     * 增加版本
     * @param appVersion
     * @return
     */
    int addAppVersion(AppVersion appVersion);
}
