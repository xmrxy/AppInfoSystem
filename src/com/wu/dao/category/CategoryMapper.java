package com.wu.dao.category;


import com.wu.pojo.AppCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CategoryMapper {

    /**
     * 根据父级id查询信息
     * @param parentId
     * @return
     */
    List<AppCategory> getCategoryList(@Param("parentId") Integer parentId);

}
