package org.siy.shop.goods.service;

import org.siy.common.service.IService;
import org.siy.shop.goods.dto.GoodsAttributeDTO;
import org.siy.shop.goods.po.GoodsAttribute;

import java.util.List;

public interface GoodsAttributeService extends IService<GoodsAttribute> {

    List<GoodsAttributeDTO> queryGoodsDetailAttributeByGoodsId(Integer goodsId);

}
