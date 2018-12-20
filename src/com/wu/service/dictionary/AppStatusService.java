package com.wu.service.dictionary;

import com.wu.pojo.AppStatus;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AppStatusService {

    /**
     * 查询App的状态
     * @return
     */
    List<AppStatus> findAppStatus();
}
