package org.siy.shop.order.fallback;

import org.springframework.stereotype.Component;
import org.siy.common.fallback.ApiFallback;
import org.siy.shop.order.api.CartApi;
import org.siy.shop.order.po.Cart;

@Component
public class CartApiFallback extends ApiFallback<Cart> implements CartApi {
}
