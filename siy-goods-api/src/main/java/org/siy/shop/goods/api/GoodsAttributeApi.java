package org.siy.shop.goods.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.siy.common.api.Api;
import org.siy.common.utils.Result;
import org.siy.shop.goods.dto.GoodsAttributeDTO;
import org.siy.shop.goods.fallback.GoodsAttributeApiFallback;
import org.siy.shop.goods.po.GoodsAttribute;

import java.util.List;

@FeignClient(value = "siy-goods", path = "goodsAttribute", fallback = GoodsAttributeApiFallback.class)
public interface GoodsAttributeApi extends Api<GoodsAttribute> {

    @GetMapping("/queryGoodsDetailAttributeByGoodsId")
    Result<List<GoodsAttributeDTO>> queryGoodsDetailAttributeByGoodsId(@RequestParam("goodsId") Integer goodsId);

}
