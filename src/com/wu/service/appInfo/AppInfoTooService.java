package com.wu.service.appInfo;

import com.wu.pojo.AppInfoToo;
import org.apache.ibatis.annotations.Param;

public interface AppInfoTooService {

    /**
     * 新增App信息
     * @return
     */
    int addAppInfoToo(AppInfoToo appInfoToo);

    /**
     * 根据APKName 查询有无数据
     * @param APKName
     * @return
     */
    int getOneAppInfoTooCount(String APKName);

    /**
     * 根据appid修改app最新版本
     * @param appId
     */
    int updateAppInfoVersion(Integer appId,Integer versionId);

    /**
     * 根据appId修改状态
     * @param appId
     * @return
     */
    int updateAppStatus(Integer appId,Integer appStatus);

    /**
     * 根据appid查询app信息
     * @param appId
     * @return
     */
    AppInfoToo findAppInfoById(Integer appId);

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
    int delApp(Integer appId);

    /**
     * 根据appid删除图片
     * @param appId
     * @return
     */
    int delAppPicture(Integer appId);
}
