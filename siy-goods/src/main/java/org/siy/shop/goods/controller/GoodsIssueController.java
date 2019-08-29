package org.siy.shop.goods.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.siy.common.api.BaseApi;
import org.siy.shop.goods.api.GoodsIssueApi;
import org.siy.shop.goods.po.GoodsIssue;

@RestController
@RequestMapping("/goodsIssue")
public class GoodsIssueController extends BaseApi<GoodsIssue> implements GoodsIssueApi {

}
