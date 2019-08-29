package org.siy.shop.goods.fallback;

import org.springframework.stereotype.Component;
import org.siy.common.fallback.ApiFallback;
import org.siy.shop.goods.api.ProductApi;
import org.siy.shop.goods.po.Product;

@Component
public class ProductApiFallback extends ApiFallback<Product> implements ProductApi {
}
