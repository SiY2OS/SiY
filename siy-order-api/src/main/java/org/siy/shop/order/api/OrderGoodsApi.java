package org.siy.shop.order.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.siy.common.api.Api;
import org.siy.shop.order.fallback.OrderGoodsApiFallback;
import org.siy.shop.order.po.OrderGoods;

@FeignClient(value = "siy-order", path = "orderGoods", fallback = OrderGoodsApiFallback.class)
public interface OrderGoodsApi extends Api<OrderGoods> {
}
