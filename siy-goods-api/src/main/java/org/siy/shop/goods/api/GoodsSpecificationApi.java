package org.siy.shop.goods.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.siy.common.api.Api;
import org.siy.common.utils.Result;
import org.siy.shop.goods.dto.GoodsSpecificationDTO;
import org.siy.shop.goods.fallback.GoodsSpecificationApiFallback;
import org.siy.shop.goods.po.GoodsSpecification;

import java.util.List;

@FeignClient(value = "siy-goods", path = "goodsSpecification", fallback = GoodsSpecificationApiFallback.class)
public interface GoodsSpecificationApi extends Api<GoodsSpecification> {

    @GetMapping("/queryGoodsDetailSpecificationByGoodsId")
    Result<List<GoodsSpecificationDTO>> queryGoodsDetailSpecificationByGoodsId(@RequestParam("goodsId") Integer goodsId);

    @GetMapping("/queryValueByGoodsIdAndIdIn")
    Result<List<String>> queryValueByGoodsIdAndIdIn(@RequestParam("goodsId") Integer goodsId, @RequestParam("goodsSpecificationIds") List<Integer> goodsSpecificationIds);
}
