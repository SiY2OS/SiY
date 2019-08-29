package org.siy.shop.order.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.siy.common.api.Api;
import org.siy.shop.order.fallback.OrderExpressApiFallback;
import org.siy.shop.order.po.OrderExpress;

@FeignClient(value = "siy-order", path = "orderExpress", fallback = OrderExpressApiFallback.class)
public interface OrderExpressApi extends Api<OrderExpress> {
}
