package org.siy.shop.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.siy.common.service.BaseService;
import org.siy.shop.user.dto.GoodsCollectDTO;
import org.siy.shop.user.mapper.CollectMapper;
import org.siy.shop.user.po.Collect;
import org.siy.shop.user.service.CollectService;

import java.util.List;

/**
 * @author Ryan
 */
@RestController
public class CollectServiceImpl extends BaseService<Collect> implements CollectService {

    @Autowired
    private CollectMapper collectMapper;

    @Override
    public List<GoodsCollectDTO> queryGoodsCollectList(Integer userId) {
        return collectMapper.selectGoodsCollectByUserId(userId);
    }
}
