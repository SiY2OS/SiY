package org.siy.shop.goods.mapper;

import org.siy.common.utils.MyMapper;
import org.siy.shop.goods.po.Goods;

import java.util.List;

public interface GoodsMapper extends MyMapper<Goods> {

    List<Goods> selectByIdIn(List<Integer> ids);
}
