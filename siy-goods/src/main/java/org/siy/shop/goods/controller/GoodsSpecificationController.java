package org.siy.shop.goods.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.siy.common.api.BaseApi;
import org.siy.common.utils.Result;
import org.siy.shop.goods.api.GoodsSpecificationApi;
import org.siy.shop.goods.dto.GoodsSpecificationDTO;
import org.siy.shop.goods.po.GoodsSpecification;
import org.siy.shop.goods.service.GoodsSpecificationService;

import java.util.List;

@RestController
@RequestMapping("/goodsSpecification")
public class GoodsSpecificationController extends BaseApi<GoodsSpecification> implements GoodsSpecificationApi {

    @Autowired
    private GoodsSpecificationService goodsSpecificationService;

    @Override
    public Result<List<GoodsSpecificationDTO>> queryGoodsDetailSpecificationByGoodsId(Integer goodsId) {
        return Result.success(goodsSpecificationService.queryGoodsDetailSpecificationByGoodsId(goodsId));
    }

    @Override
    public Result<List<String>> queryValueByGoodsIdAndIdIn(Integer goodsId, List<Integer> goodsSpecificationIds) {
        return Result.success(goodsSpecificationService.queryValueByGoodsIdAndIdIn(goodsId, goodsSpecificationIds));
    }
}
