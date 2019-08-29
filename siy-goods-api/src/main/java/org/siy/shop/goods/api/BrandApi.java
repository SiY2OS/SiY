package org.siy.shop.goods.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.siy.common.api.Api;
import org.siy.shop.goods.fallback.BrandApiFallback;
import org.siy.shop.goods.po.Brand;

/**
 * @author Ryan
 */

@FeignClient(value = "siy-goods", path = "brand", fallback = BrandApiFallback.class)
public interface BrandApi extends Api<Brand> {
}
