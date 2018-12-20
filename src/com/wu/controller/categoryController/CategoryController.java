package com.wu.controller.categoryController;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.wu.pojo.AppCategory;
import com.wu.service.category.CategoryService;
import com.wu.util.GetJsonUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value = "/category")
public class CategoryController {

    @Resource
    private CategoryService categoryService;

    @RequestMapping(value = "/categoryList.json")
    @ResponseBody
    public Object findCategoryList(@RequestParam(value = "parentId") Integer parentId){
        List<AppCategory> categoryList = categoryService.findCategoryList(parentId);
        String json = GetJsonUtil.getJson(categoryList);
        return json;
    }


}
