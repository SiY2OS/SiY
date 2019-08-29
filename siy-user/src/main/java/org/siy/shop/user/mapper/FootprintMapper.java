package org.siy.shop.user.mapper;

import org.siy.common.utils.MyMapper;
import org.siy.shop.user.dto.GoodsFootprintDTO;
import org.siy.shop.user.po.Footprint;

import java.util.List;

public interface FootprintMapper extends MyMapper<Footprint> {

    List<GoodsFootprintDTO> selectGoodsFootprintByUserId(Integer userId);

}
