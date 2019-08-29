package org.siy.shop.goods.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.siy.common.api.BaseApi;
import org.siy.common.utils.Result;
import org.siy.shop.goods.api.GoodsAttributeApi;
import org.siy.shop.goods.dto.GoodsAttributeDTO;
import org.siy.shop.goods.po.GoodsAttribute;
import org.siy.shop.goods.service.GoodsAttributeService;

import java.util.List;

@RestController
@RequestMapping("/goodsAttribute")
public class GoodsAttributeController extends BaseApi<GoodsAttribute> implements GoodsAttributeApi {

    private GoodsAttributeService goodsAttributeService;

    @Override
    public Result<List<GoodsAttributeDTO>> queryGoodsDetailAttributeByGoodsId(Integer goodsId) {
        return Result.success(goodsAttributeService.queryGoodsDetailAttributeByGoodsId(goodsId));
    }
}
