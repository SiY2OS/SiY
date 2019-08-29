package org.siy.shop.goods.service;

import org.siy.common.service.IService;
import org.siy.shop.goods.po.Category;

import java.util.List;

/**
 * @author Ryan
 */
public interface CategoryService extends IService<Category> {

    List<Integer> queryIdsByParentId(Integer parentId);

    List<Integer> queryParentIdsByIdIn(List<Integer> ids);

    List<Category> queryByIdIn(List<Integer> ids);
}
