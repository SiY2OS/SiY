package org.siy.shop.goods.service;

import org.siy.common.service.IService;
import org.siy.shop.goods.dto.GoodsSpecificationDTO;
import org.siy.shop.goods.po.GoodsSpecification;

import java.util.List;

public interface GoodsSpecificationService extends IService<GoodsSpecification> {

    List<GoodsSpecificationDTO> queryGoodsDetailSpecificationByGoodsId(Integer goodsId);

    List<String> queryValueByGoodsIdAndIdIn(Integer goodsId, List<Integer> goodsSpecificationIds);
}
