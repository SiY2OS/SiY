package org.siy.shop.order.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.siy.common.api.Api;
import org.siy.shop.order.fallback.CartApiFallback;
import org.siy.shop.order.po.Cart;

@FeignClient(value = "siy-order", path = "cart", fallback = CartApiFallback.class)
public interface CartApi extends Api<Cart> {
}
