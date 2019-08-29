package org.siy.shop.order.fallback;

import org.springframework.stereotype.Component;
import org.siy.common.fallback.ApiFallback;
import org.siy.shop.order.api.OrderApi;
import org.siy.shop.order.po.Order;

@Component
public class OrderApiFallback extends ApiFallback<Order> implements OrderApi {
}
