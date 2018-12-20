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

}
