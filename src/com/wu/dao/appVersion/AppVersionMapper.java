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
}
