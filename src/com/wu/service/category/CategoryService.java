package com.wu.service.category;

import com.wu.pojo.AppCategory;

import java.util.List;

public interface CategoryService {

    /**
     * 根据父级id查询信息
     * @param parentId
     * @return
     */
    List<AppCategory> findCategoryList(Integer parentId);
}
