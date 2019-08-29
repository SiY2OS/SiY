package org.siy.shop.goods.fallback;

import org.springframework.stereotype.Component;
import org.siy.common.fallback.ApiFallback;
import org.siy.shop.goods.api.GoodsIssueApi;
import org.siy.shop.goods.po.GoodsIssue;

@Component
public class GoodsIssueApiFallback extends ApiFallback<GoodsIssue> implements GoodsIssueApi {
}
