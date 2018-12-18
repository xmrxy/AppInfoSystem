package com.wu.dao.dataDictionary;

import com.wu.pojo.DataDictionary;
import org.apache.ibatis.annotations.Param;

public interface DataDictionaryMapper {

    /**
     * 根据id查询信息
     * @param id
     * @return
     */
    DataDictionary getOneDictionary(@Param("data_id") Integer id);
}
