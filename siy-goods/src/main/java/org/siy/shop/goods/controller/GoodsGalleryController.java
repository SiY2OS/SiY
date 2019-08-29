package org.siy.shop.goods.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.siy.common.api.BaseApi;
import org.siy.shop.goods.api.GoodsGalleryApi;
import org.siy.shop.goods.po.GoodsGallery;

@RestController
@RequestMapping("/goodsGallery")
public class GoodsGalleryController extends BaseApi<GoodsGallery> implements GoodsGalleryApi {
}
