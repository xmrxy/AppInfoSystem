package com.wu.service.dictionary.impl;

import com.wu.dao.dictionary.PingTaiMapper;
import com.wu.pojo.PingTai;
import com.wu.service.dictionary.PingTaiService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PingTaiServiceImpl implements PingTaiService {

    @Resource
    private PingTaiMapper pintTaiMapper;

    @Override
    public List<PingTai> findPingTaiInfo() {
        return pintTaiMapper.getPingTaiInfo();
    }
}
