package org.siy.shop.goods.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.siy.common.api.Api;
import org.siy.shop.goods.fallback.GoodsGalleryApiFallback;
import org.siy.shop.goods.po.GoodsGallery;

@FeignClient(value = "siy-goods", path = "goodsGallery", fallback = GoodsGalleryApiFallback.class)
public interface GoodsGalleryApi extends Api<GoodsGallery> {

}
