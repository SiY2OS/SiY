package org.siy.shop.wechat.service;

import org.siy.shop.goods.po.Goods;
import org.siy.shop.goods.query.GoodsSearchQuery;
import org.siy.shop.wechat.vo.GoodsCategoryVO;
import org.siy.shop.wechat.vo.GoodsDetailVO;
import org.siy.shop.wechat.vo.GoodsListVO;
import org.siy.shop.wechat.vo.GoodsResultVO;

import java.util.List;

public interface WechatGoodsService {

    List<Goods> queryListByCategoryIdIn(List<Integer> categoryIdList);

    GoodsResultVO queryList(GoodsSearchQuery goodsSearchQuery);

    GoodsDetailVO queryGoodsDetail(Integer goodsId);

    List<GoodsListVO> queryRelatedGoods(Integer goodsId);

    GoodsCategoryVO queryGoodsCategory(Integer categoryId);

}
