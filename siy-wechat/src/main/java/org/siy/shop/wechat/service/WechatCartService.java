package org.siy.shop.wechat.service;

import org.siy.shop.wechat.vo.*;

public interface WechatCartService {

    CartResultVO getCart();

    void deleteCartGoods(CartGoodsDeleteVO deleteVO);

    void checkedCartGoods(CartCheckedVO cartCheckedVO);

    void addGoodsToCart(CartParamVO cartParamDTO);

    void updateGoods(CartParamVO cartParamDTO);

    CartCheckoutVO checkoutCart(Integer addressId, Integer couponId);

}
