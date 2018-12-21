package com.wu.dao.appVersion;

import com.wu.pojo.AppVersion;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppVersionMapper {

    /**
     * 根据appid查询版本信息
     * @param appId
     * @return
     */
   List<AppVersion> AppVersionList(@Param("appId") Integer appId);


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
   int delApk(@Param("versionId") Integer versionId);

    /**
     * 根据versionid查询版本信息
     * @param versionId
     * @return
     */
   AppVersion getOneAppVersionByVersionId(@Param("versionId") Integer versionId);

}
