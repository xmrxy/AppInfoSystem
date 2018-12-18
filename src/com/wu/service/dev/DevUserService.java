package com.wu.service.dev;

import com.wu.pojo.DevUser;

public interface DevUserService {

    /**
     * 根据开发者账号和密码查询开发者用户
     * @param devCode
     * @param devPassword
     * @return
     */
    DevUser findOneDevUser(String devCode,String devPassword);
}
