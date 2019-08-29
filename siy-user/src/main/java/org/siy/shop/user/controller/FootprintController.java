package org.siy.shop.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.siy.common.api.BaseApi;
import org.siy.common.utils.Result;
import org.siy.shop.user.api.FootprintApi;
import org.siy.shop.user.dto.GoodsFootprintDTO;
import org.siy.shop.user.po.Footprint;
import org.siy.shop.user.service.FootprintService;

import java.util.List;

@RestController
@RequestMapping("footprint")
public class FootprintController extends BaseApi<Footprint> implements FootprintApi {

    @Autowired
    private FootprintService footprintService;

    @Override
    public Result<List<GoodsFootprintDTO>> queryGoodsFootprintByUserId(Integer userId) {
        return Result.success(footprintService.queryGoodsFootprintByUserId(userId));
    }
}
