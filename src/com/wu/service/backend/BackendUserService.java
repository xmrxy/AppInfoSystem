package com.wu.service.backend;

import com.wu.pojo.BackendUser;

public interface BackendUserService {

    /**
     * 根据账号密码获取一个backeng用户
     * @param userCode
     * @param userPassword
     * @return
     */
    BackendUser fingOneBackendUser(String userCode,String userPassword);
}
