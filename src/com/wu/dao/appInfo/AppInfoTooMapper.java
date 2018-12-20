package com.wu.dao.appInfo;

import com.wu.pojo.AppInfoToo;
import org.apache.ibatis.annotations.Param;

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

}
