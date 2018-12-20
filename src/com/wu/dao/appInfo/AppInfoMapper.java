package com.wu.dao.appInfo;

import com.wu.pojo.AppInfoToo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppInfoMapper {

    /**
     * 获取app维护页面的App字段信息
     * @return
     */
   List<AppInfoToo> getAppInfo(@Param("softwareName") String softwareName,
                               @Param("APKName") String APKName,
                               @Param("softwareSize") Double softwareSize,
                               @Param("valueNamePingTai")  Integer valueNamePingTai,
                               @Param("categoryName1")  Integer categoryName1,
                               @Param("categoryName2")  Integer categoryName2,
                               @Param("categoryName3") Integer categoryName3,
                               @Param("valueNameStatus") Integer valueNameStatus,
                               @Param("downloads") Integer downloads,
                               @Param("versionId") Integer versionId,
                               @Param("startRow") Integer startRow,
                               @Param("pageSize") Integer pageSize);


    /**
     * 查询Appinfo的总数据量
     * @return
     */
   int getAppInfoCount(@Param("softwareName") String softwareName,
                       @Param("APKName") String APKName,
                       @Param("softwareSize") Double softwareSize,
                       @Param("valueNamePingTai")  Integer valueNamePingTai,
                       @Param("categoryName1")  Integer categoryName1,
                       @Param("categoryName2")  Integer categoryName2,
                       @Param("categoryName3") Integer categoryName3,
                       @Param("valueNameStatus") Integer valueNameStatus,
                       @Param("downloads") Integer downloads,
                       @Param("versionId") Integer versionId);
}
