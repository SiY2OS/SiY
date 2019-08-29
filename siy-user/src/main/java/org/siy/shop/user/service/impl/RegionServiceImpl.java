package org.siy.shop.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.siy.common.service.BaseService;
import org.siy.shop.user.mapper.RegionMapper;
import org.siy.shop.user.po.Region;
import org.siy.shop.user.service.RegionService;

/**
 * @author Ryan
 */
@RestController
public class RegionServiceImpl extends BaseService<Region> implements RegionService {

    @Autowired
    private RegionMapper regionMapper;

    @Override
    public String queryNameById(Short id) {
        return regionMapper.selectNameById(id);
    }
}
