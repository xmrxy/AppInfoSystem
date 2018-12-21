package com.wu.dao.dev;

import com.wu.pojo.DevUser;
import org.apache.ibatis.annotations.Param;

public interface DevUserMapper {

    /**
     * 根据开发者账号和密码查询开发者用户
     * @param devCode
     * @param devPassword
     * @return
     */
  DevUser getOneDevUser(@Param("devCode") String devCode, @Param("devPassword") String devPassword);


}
