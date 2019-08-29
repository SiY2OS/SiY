package org.siy.shop.order.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.siy.common.api.BaseApi;
import org.siy.shop.order.api.CartApi;
import org.siy.shop.order.po.Cart;

@RequestMapping("/cart")
@RestController
public class CartController extends BaseApi<Cart> implements CartApi {
}
