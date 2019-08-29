package org.siy.shop.goods.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.siy.common.service.BaseService;
import org.siy.shop.goods.dto.GoodsAttributeDTO;
import org.siy.shop.goods.mapper.GoodsAttributeMapper;
import org.siy.shop.goods.po.GoodsAttribute;
import org.siy.shop.goods.service.GoodsAttributeService;

import java.util.List;

@Service
public class GoodsAttributeServiceImpl extends BaseService<GoodsAttribute> implements GoodsAttributeService {

    @Autowired
    private GoodsAttributeMapper goodsAttributeMapper;

    @Override
    public List<GoodsAttributeDTO> queryGoodsDetailAttributeByGoodsId(Integer goodsId) {
        return goodsAttributeMapper.selectGoodsDetailAttributeByGoodsId(goodsId);
    }
}
