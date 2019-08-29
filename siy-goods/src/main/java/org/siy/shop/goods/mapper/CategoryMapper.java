package org.siy.shop.goods.mapper;

import org.siy.common.utils.MyMapper;
import org.siy.shop.goods.po.Category;

import java.util.List;

public interface CategoryMapper extends MyMapper<Category> {

    List<Integer> selectIdsByParentId(Integer parentId);

    List<Integer> selectParentIdsByIdIn(List<Integer> ids);

    List<Category> selectByIdIn(List<Integer> ids);

}
