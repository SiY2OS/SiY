package org.siy.shop.user.mapper;

import org.siy.common.utils.MyMapper;
import org.siy.shop.user.dto.GoodsCollectDTO;
import org.siy.shop.user.po.Collect;

import java.util.List;

public interface CollectMapper extends MyMapper<Collect> {

    List<GoodsCollectDTO> selectGoodsCollectByUserId(Integer userId);

}
