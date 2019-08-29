package org.siy.shop.goods.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.siy.common.api.BaseApi;
import org.siy.shop.goods.api.GoodsApi;
import org.siy.shop.goods.po.Goods;

@RestController
@RequestMapping("/goods")
public class GoodsController extends BaseApi<Goods> implements GoodsApi {
}
