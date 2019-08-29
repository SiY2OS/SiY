package org.siy.shop.goods.fallback;

import org.springframework.stereotype.Component;
import org.siy.common.fallback.ApiFallback;
import org.siy.shop.goods.api.GoodsApi;
import org.siy.shop.goods.po.Goods;

@Component
public class GoodsApiFallback extends ApiFallback<Goods> implements GoodsApi {
}
