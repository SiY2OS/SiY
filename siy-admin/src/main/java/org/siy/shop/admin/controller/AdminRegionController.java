package org.siy.shop.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.siy.common.controller.BaseController;
import org.siy.common.utils.Criteria;
import org.siy.common.utils.Result;
import org.siy.shop.user.api.RegionApi;
import org.siy.shop.user.enums.RegionTypeEnum;
import org.siy.shop.user.po.Region;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Ryan
 */
@RestController
@RequestMapping("/admin/region")
public class AdminRegionController extends BaseController {

    @Autowired
    private RegionApi regionApi;

    @GetMapping("/list")
    public Result<List<Region>> queryList() {
        return regionApi.queryByCriteria(Criteria.of(Region.class))
                .addExtra("regionType", Arrays.stream(RegionTypeEnum.values()).collect(Collectors.toMap(e -> e, RegionTypeEnum::getName)));
    }
}
