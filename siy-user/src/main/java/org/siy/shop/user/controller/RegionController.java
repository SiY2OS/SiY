package org.siy.shop.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.siy.common.api.BaseApi;
import org.siy.common.utils.Result;
import org.siy.shop.user.api.RegionApi;
import org.siy.shop.user.po.Region;
import org.siy.shop.user.service.RegionService;

@RestController
@RequestMapping("region")
public class RegionController extends BaseApi<Region> implements RegionApi {

    @Autowired
    private RegionService regionService;

    @Override
    public Result<String> queryNameById(Short id) {
        return Result.success(regionService.queryNameById(id));
    }
}
