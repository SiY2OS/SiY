package org.siy.shop.order.fallback;

import org.springframework.stereotype.Component;
import org.siy.common.fallback.ApiFallback;
import org.siy.shop.order.api.OrderGoodsApi;
import org.siy.shop.order.po.OrderGoods;

@Component
public class OrderGoodsApiFallback extends ApiFallback<OrderGoods> implements OrderGoodsApi {

}
