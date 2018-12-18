package com.wu.service.dataDictionary.impl;

import com.wu.dao.dataDictionary.DataDictionaryMapper;
import com.wu.pojo.DataDictionary;
import com.wu.service.dataDictionary.DataDictionaryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DataDictionaryServiceImpl implements DataDictionaryService {

    @Resource
    private DataDictionaryMapper dataDictionaryMapper;


    @Override
    public DataDictionary findOneDictionary(Integer id) {
        return dataDictionaryMapper.getOneDictionary(id);
    }
}
