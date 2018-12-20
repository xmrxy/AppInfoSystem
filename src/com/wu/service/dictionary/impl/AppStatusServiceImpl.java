package com.wu.service.dictionary.impl;

import com.wu.dao.dictionary.AppStatusMapper;
import com.wu.pojo.AppStatus;
import com.wu.service.dictionary.AppStatusService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AppStatusServiceImpl implements AppStatusService {

    @Resource
    private AppStatusMapper appStatusMapper;


    @Override
    public List<AppStatus> findAppStatus() {
        return appStatusMapper.getAppStatus();
    }
}
