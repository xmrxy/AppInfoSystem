package com.wu.service.appInfo;

import com.wu.pojo.AppInfoToo;

import java.util.List;

public interface AppInfoService {

    /**
     * 获取app维护页面的App字段信息
     * @return
     */
    List<AppInfoToo> findAppInfo(String softwareName,
                                 String APKName,
                                 Double softwareSize,
                                 Integer valueNamePingTai,
                                 Integer categoryName1,
                                 Integer categoryName2,
                                 Integer categoryName3,
                                 Integer valueNameStatus,
                                 Integer downloads,
                                 Integer versionId, Integer startRow, Integer pageSize);

    /**
     * 查询appinfo数量
     * @param softwareName
     * @param APKName
     * @param softwareSize
     * @param valueNamePingTai
     * @param categoryName1
     * @param categoryName2
     * @param categoryName3
     * @param valueNameStatus
     * @param downloads
     * @param versionId
     * @return
     */
    int findAppInfoCount(String softwareName,
                         String APKName,
                         Double softwareSize,
                         Integer valueNamePingTai,
                         Integer categoryName1,
                         Integer categoryName2,
                         Integer categoryName3,
                         Integer valueNameStatus,
                         Integer downloads,
                         Integer versionId);


}
