package org.siy.shop.order.fallback;

import org.springframework.stereotype.Component;
import org.siy.common.fallback.ApiFallback;
import org.siy.shop.order.api.OrderExpressApi;
import org.siy.shop.order.po.OrderExpress;

@Component
public class OrderExpressApiFallback extends ApiFallback<OrderExpress> implements OrderExpressApi {
}
