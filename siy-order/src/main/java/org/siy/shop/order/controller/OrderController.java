package org.siy.shop.order.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.siy.common.api.BaseApi;
import org.siy.shop.order.api.OrderApi;
import org.siy.shop.order.po.Order;

@RestController
@RequestMapping("/order")
public class OrderController extends BaseApi<Order> implements OrderApi {
}
