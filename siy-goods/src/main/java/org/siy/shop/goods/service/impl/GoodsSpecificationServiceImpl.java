package org.siy.shop.goods.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.siy.common.service.BaseService;
import org.siy.shop.goods.dto.GoodsSpecificationDTO;
import org.siy.shop.goods.mapper.GoodsSpecificationMapper;
import org.siy.shop.goods.po.GoodsSpecification;
import org.siy.shop.goods.service.GoodsSpecificationService;

import java.util.List;

@Service
public class GoodsSpecificationServiceImpl extends BaseService<GoodsSpecification> implements GoodsSpecificationService {

    @Autowired
    private GoodsSpecificationMapper goodsSpecificationMapper;

    @Override
    public List<GoodsSpecificationDTO> queryGoodsDetailSpecificationByGoodsId(Integer goodsId) {
        return goodsSpecificationMapper.selectGoodsDetailSpecificationByGoodsId(goodsId);
    }

    @Override
    public List<String> queryValueByGoodsIdAndIdIn(Integer goodsId, List<Integer> goodsSpecificationIds) {
        return goodsSpecificationMapper.selectValueByGoodsIdAndIdIn(goodsId, goodsSpecificationIds);
    }
}
