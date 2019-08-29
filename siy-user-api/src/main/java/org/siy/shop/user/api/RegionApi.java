package org.siy.shop.user.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.siy.common.api.Api;
import org.siy.common.utils.Result;
import org.siy.shop.user.fallback.RegionApiFallback;
import org.siy.shop.user.po.Region;

@FeignClient(value = "siy-user", path = "region", fallback = RegionApiFallback.class)
public interface RegionApi extends Api<Region> {

    @GetMapping("/queryNameById")
    Result<String> queryNameById(@RequestParam("id") Short id);
}
