package org.siy.shop.goods.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.siy.common.api.Api;
import org.siy.shop.goods.fallback.GoodsApiFallback;
import org.siy.shop.goods.po.Goods;

/**
 * @author Ryan
 */
@FeignClient(value = "siy-goods", path = "goods", fallback = GoodsApiFallback.class)
public interface GoodsApi extends Api<Goods> {
}
