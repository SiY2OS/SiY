package org.siy.shop.goods.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.siy.common.api.Api;
import org.siy.shop.goods.fallback.RelatedGoodsApiFallback;
import org.siy.shop.goods.po.RelatedGoods;

@FeignClient(value = "siy-goods", path = "related-goods", fallback = RelatedGoodsApiFallback.class)
public interface RelatedGoodsApi extends Api<RelatedGoods> {
}
