package com.wu.service.dev.impl;

import com.wu.dao.dev.DevUserMapper;
import com.wu.pojo.DevUser;
import com.wu.service.dev.DevUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("devUserService")
public class DevUserServiceImpl implements DevUserService {

    @Resource
    private DevUserMapper devUserMapper;

    @Override
    public DevUser findOneDevUser(String devCode, String devPassword) {
        return devUserMapper.getOneDevUser(devCode, devPassword);
    }
}
