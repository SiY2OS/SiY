package org.siy.shop.goods.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.siy.common.service.BaseService;
import org.siy.shop.goods.mapper.CategoryMapper;
import org.siy.shop.goods.po.Category;
import org.siy.shop.goods.service.CategoryService;

import java.util.List;

/**
 * @author Ryan
 */
@Service
public class CategoryServiceImpl extends BaseService<Category> implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;


    @Override
    public List<Integer> queryIdsByParentId(Integer parentId) {
        return categoryMapper.selectIdsByParentId(parentId);
    }

    @Override
    public List<Integer> queryParentIdsByIdIn(List<Integer> ids) {
        return categoryMapper.selectParentIdsByIdIn(ids);
    }

    @Override
    public List<Category> queryByIdIn(List<Integer> ids) {
        return categoryMapper.selectByIdIn(ids);
    }
}
