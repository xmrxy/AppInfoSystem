package com.wu.service.category.impl;

import com.wu.dao.category.CategoryMapper;
import com.wu.pojo.AppCategory;
import com.wu.service.category.CategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Resource
    private CategoryMapper categoryMapper;


    @Override
    public List<AppCategory> findCategoryList(Integer parentId) {
        return  categoryMapper.getCategoryList(parentId);
    }
}
