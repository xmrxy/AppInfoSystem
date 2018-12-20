package com.wu.dao.dictionary;

import com.wu.pojo.PingTai;

import java.util.List;

public interface PingTaiMapper {

    /**
     * 获取所有平台信息
     * @return
     */
   List<PingTai> getPingTaiInfo();
}
