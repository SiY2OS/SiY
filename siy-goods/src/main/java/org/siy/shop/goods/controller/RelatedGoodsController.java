package org.siy.shop.goods.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.siy.common.api.BaseApi;
import org.siy.shop.goods.api.RelatedGoodsApi;
import org.siy.shop.goods.po.RelatedGoods;

@RequestMapping("related-goods")
@RestController
public class RelatedGoodsController extends BaseApi<RelatedGoods> implements RelatedGoodsApi {

}
