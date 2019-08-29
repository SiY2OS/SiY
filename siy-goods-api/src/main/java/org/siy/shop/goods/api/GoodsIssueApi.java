package org.siy.shop.goods.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.siy.common.api.Api;
import org.siy.shop.goods.fallback.GoodsIssueApiFallback;
import org.siy.shop.goods.po.GoodsIssue;

@FeignClient(value = "siy-goods", path = "goodsIssue", fallback = GoodsIssueApiFallback.class)
public interface GoodsIssueApi extends Api<GoodsIssue> {

}
