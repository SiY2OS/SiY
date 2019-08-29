package org.siy.shop.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.siy.common.service.BaseService;
import org.siy.shop.user.dto.GoodsFootprintDTO;
import org.siy.shop.user.mapper.FootprintMapper;
import org.siy.shop.user.po.Footprint;
import org.siy.shop.user.service.FootprintService;

import java.util.List;

/**
 * @author Ryan
 */
@Service
public class FootprintServiceImpl extends BaseService<Footprint> implements FootprintService {

    @Autowired
    private FootprintMapper footprintMapper;

    @Override
    public List<GoodsFootprintDTO> queryGoodsFootprintByUserId(Integer userId) {
        return footprintMapper.selectGoodsFootprintByUserId(userId);
    }
}
