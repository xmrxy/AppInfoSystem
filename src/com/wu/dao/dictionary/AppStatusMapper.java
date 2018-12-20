package com.wu.dao.dictionary;

import com.wu.pojo.AppStatus;

import java.util.List;

public interface AppStatusMapper {

    /**
     * 查询app状态
     * @return
     */
   List<AppStatus> getAppStatus();
}
