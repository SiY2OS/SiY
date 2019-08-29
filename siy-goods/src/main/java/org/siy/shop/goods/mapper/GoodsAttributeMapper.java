package org.siy.shop.goods.mapper;

import org.siy.common.utils.MyMapper;
import org.siy.shop.goods.dto.GoodsAttributeDTO;
import org.siy.shop.goods.po.GoodsAttribute;

import java.util.List;

public interface GoodsAttributeMapper extends MyMapper<GoodsAttribute> {

    List<GoodsAttributeDTO> selectGoodsDetailAttributeByGoodsId(Integer goodsId);
}
