package org.siy.shop.admin.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.siy.common.controller.BaseController;
import org.siy.common.utils.Criteria;
import org.siy.common.utils.Result;
import org.siy.shop.goods.api.CategoryApi;
import org.siy.shop.goods.enums.CategoryLevelEnum;
import org.siy.shop.goods.po.Category;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Ryan
 */
@RestController
@RequestMapping("/admin/category")
public class AdminCategoryController extends BaseController {

    @Autowired
    private CategoryApi categoryApi;

    @GetMapping("/list")
    public Result<List<Category>> queryList() {
        return categoryApi.queryByCriteria(Criteria.of(Category.class))
                .addExtra("categoryLevel", Arrays.stream(CategoryLevelEnum.values()).collect(Collectors.toMap(c -> c, CategoryLevelEnum::getName)))
                .addExtra("l1", categoryApi.queryList(new Category().setLevel(CategoryLevelEnum.L1)).getData());
    }
}
