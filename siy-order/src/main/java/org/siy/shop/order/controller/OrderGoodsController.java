package org.siy.shop.order.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.siy.common.api.BaseApi;
import org.siy.shop.order.api.OrderGoodsApi;
import org.siy.shop.order.po.OrderGoods;

@RestController
@RequestMapping("/orderGoods")
public class OrderGoodsController extends BaseApi<OrderGoods> implements OrderGoodsApi {
}
