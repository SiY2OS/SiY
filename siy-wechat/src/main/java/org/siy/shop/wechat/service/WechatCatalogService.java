package org.siy.shop.wechat.service;

import org.siy.shop.goods.enums.CategoryLevelEnum;
import org.siy.shop.goods.po.Category;
import org.siy.shop.wechat.vo.CategoryIndexVO;
import org.siy.shop.wechat.vo.CategoryVO;

import java.util.List;

public interface WechatCatalogService {

    /**
     * 根据类目查询商品
     *
     * @param categoryLevel
     * @return
     */
    List<Category> queryCategoryByLevel(CategoryLevelEnum categoryLevel);

    CategoryIndexVO index(Integer cateogyId);

    CategoryVO current(Integer id);

}
