package org.siy.shop.order.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.siy.common.api.Api;
import org.siy.shop.order.fallback.OrderApiFallback;
import org.siy.shop.order.po.Order;

@FeignClient(value = "siy-order", path = "order", fallback = OrderApiFallback.class)
public interface OrderApi extends Api<Order> {
}
