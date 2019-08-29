package org.siy.shop.goods.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.siy.common.api.BaseApi;
import org.siy.shop.goods.api.ProductApi;
import org.siy.shop.goods.po.Product;

@RequestMapping("/product")
@RestController
public class ProductController extends BaseApi<Product> implements ProductApi {
}
