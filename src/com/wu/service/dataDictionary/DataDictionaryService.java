package com.wu.service.dataDictionary;

import com.wu.pojo.DataDictionary;

public interface DataDictionaryService {
    /**
     * 根据id查询信息
     * @param id
     * @return
     */
    DataDictionary findOneDictionary(Integer id);
}
