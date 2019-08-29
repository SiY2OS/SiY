package org.siy.shop.user.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.siy.common.api.Api;
import org.siy.common.utils.Result;
import org.siy.shop.user.dto.GoodsCollectDTO;
import org.siy.shop.user.fallback.CollectApiFallback;
import org.siy.shop.user.po.Collect;

import java.util.List;

@FeignClient(value = "siy-user", path = "collect", fallback = CollectApiFallback.class)
public interface CollectApi extends Api<Collect> {

    @GetMapping("/queryGoodsCollectList")
    Result<List<GoodsCollectDTO>> queryGoodsCollectList(Integer userId);
}
