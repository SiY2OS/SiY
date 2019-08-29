package org.siy.shop.goods.fallback;

import org.springframework.stereotype.Component;
import org.siy.common.fallback.ApiFallback;
import org.siy.shop.goods.api.GoodsGalleryApi;
import org.siy.shop.goods.po.GoodsGallery;

@Component
public class GoodsGalleryApiFallback extends ApiFallback<GoodsGallery> implements GoodsGalleryApi {
}
