package com.wu.dao.backend;

import com.wu.pojo.BackendUser;
import org.apache.ibatis.annotations.Param;

public interface BackendUserMapper {


    /**
     * 根据账号密码获取一个backeng用户
     * @param userCode
     * @param userPassword
     * @return
     */
    BackendUser getOneBankendUser(@Param("userCode") String userCode, @Param("userPassword") String userPassword);
}
