package com.wu.service.appVersion;

import com.wu.pojo.AppVersion;
import org.apache.ibatis.annotations.Param;

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

    /**
     * 修改版本
     * @param appVersion
     * @return
     */
    int updateAppVersion(AppVersion appVersion);

    /**
     * 根据versionid删除apk文件
     * @param versionId
     * @return
     */
    int delApk(Integer versionId);

    /**
     * 根据versionid查询版本信息
     * @param versionId
     * @return
     */
    AppVersion findOneAppVersionByVersionId(Integer versionId);
}
