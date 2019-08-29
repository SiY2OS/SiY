package org.siy.shop.order.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.siy.common.api.BaseApi;
import org.siy.shop.order.api.OrderExpressApi;
import org.siy.shop.order.po.OrderExpress;

@RestController
@RequestMapping("/orderExpress")
public class OrderExpressController extends BaseApi<OrderExpress> implements OrderExpressApi {
}
