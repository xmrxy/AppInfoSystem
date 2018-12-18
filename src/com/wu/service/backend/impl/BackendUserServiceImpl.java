package com.wu.service.backend.impl;

import com.wu.dao.backend.BackendUserMapper;
import com.wu.pojo.BackendUser;
import com.wu.service.backend.BackendUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service("backendUserService")
public class BackendUserServiceImpl implements BackendUserService {

    @Resource
    private BackendUserMapper backendUserMapper;

    @Override
    public BackendUser fingOneBackendUser(String userCode, String userPassword) {
           return backendUserMapper.getOneBankendUser(userCode, userPassword);

    }
}
