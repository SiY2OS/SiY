package org.siy.shop.goods.fallback;

import org.springframework.stereotype.Component;
import org.siy.common.fallback.ApiFallback;
import org.siy.shop.goods.api.RelatedGoodsApi;
import org.siy.shop.goods.po.RelatedGoods;

@Component
public class RelatedGoodsApiFallback extends ApiFallback<RelatedGoods> implements RelatedGoodsApi {
}
