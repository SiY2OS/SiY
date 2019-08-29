package org.siy.shop.goods.mapper;

import org.apache.ibatis.annotations.Param;
import org.siy.common.utils.MyMapper;
import org.siy.shop.goods.dto.GoodsSpecificationDTO;
import org.siy.shop.goods.po.GoodsSpecification;

import java.util.List;

public interface GoodsSpecificationMapper extends MyMapper<GoodsSpecification> {

    List<GoodsSpecificationDTO> selectGoodsDetailSpecificationByGoodsId(Integer goodsId);

    List<String> selectValueByGoodsIdAndIdIn(Integer goodsId, @Param("list") List<Integer> goodsSpecificationIds);
}
