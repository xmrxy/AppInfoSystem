package com.wu.service.appInfo.impl;

import com.wu.dao.appInfo.AppInfoMapper;
import com.wu.pojo.AppInfoToo;
import com.wu.service.appInfo.AppInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AppInfoServiceImpl implements AppInfoService {

    @Resource
    private AppInfoMapper appInfoMapper;

    @Override
    public List<AppInfoToo> findAppInfo(String softwareName, String APKName, Double softwareSize,
                                        Integer valueName_pingTai, Integer categoryName1,
                                        Integer categoryName2, Integer categoryName3,
                                        Integer valueNameStatus, Integer downloads,
                                        Integer versionId, Integer startRow, Integer pageSize) {
        return appInfoMapper.getAppInfo(softwareName,APKName,softwareSize,valueName_pingTai,
                                        categoryName1,categoryName2,categoryName3,
                                         valueNameStatus,downloads,versionId,startRow,pageSize);
    }


    @Override
    public int findAppInfoCount(String softwareName, String APKName, Double softwareSize, Integer valueNamePingTai, Integer categoryName1, Integer categoryName2, Integer categoryName3, Integer valueNameStatus, Integer downloads, Integer versionId) {
        return appInfoMapper.getAppInfoCount(softwareName,APKName,softwareSize,valueNamePingTai,categoryName1,categoryName2,categoryName3,valueNameStatus,downloads,versionId);
    }
}
