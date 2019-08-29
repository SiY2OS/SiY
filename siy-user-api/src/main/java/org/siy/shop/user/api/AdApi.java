package org.siy.shop.user.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.siy.common.api.Api;
import org.siy.shop.user.fallback.AdApiFallback;
import org.siy.shop.user.po.Ad;

@FeignClient(value = "siy-user", path = "ad", fallback = AdApiFallback.class)
public interface AdApi extends Api<Ad> {
}
