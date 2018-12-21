package com.wu.dao.appInfo;

import com.wu.pojo.AppInfoToo;
import org.apache.ibatis.annotations.Param;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.jmx.export.annotation.ManagedOperationParameter;

public interface AppInfoTooMapper {


    /**
     * 新增App信息
     * @return
     */
   int addAppInfoToo(AppInfoToo appInfoToo);

    /**
     * 根据APKName名字查询一个AppInfoToo
     * @param APKName
     * @return
     */
   int getOneAppInfoTooCount(@Param("APKName") String APKName);

    /**
     * 根据appid修改app最新版本
     * @param appId
     */
   int updateAppInfoVersion(@Param("appId") Integer appId,
                            @Param("versionId") Integer versionId);


    /**
     * 根据appId修改状态
     * @param appId
     * @return
     */
   int updateAppStatus(@Param("appId") Integer appId,@Param("appStatus")Integer appStatus);

    /**
     * 根据appid查询app信息
     * @param appId
     * @return
     */
   AppInfoToo getAppInfoById(@Param("appId") Integer appId);

    /**
     * 修改app信息
     * @param appInfoToo
     * @return
     */
   int updateAppInfo(AppInfoToo appInfoToo);

    /**
     * 删除app
     * @param appId
     * @return
     */
   int delApp(@Param("appId") Integer appId);

    /**
     * 根据appid删除图片
     * @param appId
     * @return
     */
   int delAppPicture(@Param("appId") Integer appId);

}
