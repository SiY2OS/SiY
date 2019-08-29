package org.siy.shop.goods.fallback;

import org.springframework.stereotype.Component;
import org.siy.common.fallback.ApiFallback;
import org.siy.shop.goods.api.BrandApi;
import org.siy.shop.goods.po.Brand;

@Component
public class BrandApiFallback extends ApiFallback<Brand> implements BrandApi {


}
