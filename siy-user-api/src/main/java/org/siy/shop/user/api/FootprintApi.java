package org.siy.shop.user.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.siy.common.api.Api;
import org.siy.common.utils.Result;
import org.siy.shop.user.dto.GoodsFootprintDTO;
import org.siy.shop.user.fallback.FootprintApiFallback;
import org.siy.shop.user.po.Footprint;

import java.util.List;

@FeignClient(value = "siy-user", path = "footprint", fallback = FootprintApiFallback.class)
public interface FootprintApi extends Api<Footprint> {

    @GetMapping("/queryGoodsFootprintByUserId")
    Result<List<GoodsFootprintDTO>> queryGoodsFootprintByUserId(@RequestParam("id") Integer userId);
}
