package com.wu.service.dictionary;

import com.wu.pojo.PingTai;

import java.util.List;

public interface PingTaiService {
    /**
     * 获取平台信息
     * @return
     */
    List<PingTai> findPingTaiInfo();
}
