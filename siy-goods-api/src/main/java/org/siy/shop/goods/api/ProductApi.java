package org.siy.shop.goods.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.siy.common.api.Api;
import org.siy.shop.goods.fallback.ProductApiFallback;
import org.siy.shop.goods.po.Product;

@FeignClient(value = "siy-goods", path = "product", fallback = ProductApiFallback.class)
public interface ProductApi extends Api<Product> {
}
