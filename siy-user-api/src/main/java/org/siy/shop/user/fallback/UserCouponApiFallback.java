package org.siy.shop.user.fallback;

import org.springframework.stereotype.Component;
import org.siy.common.fallback.ApiFallback;
import org.siy.shop.user.api.UserCouponApi;
import org.siy.shop.user.po.UserCoupon;

@Component
public class UserCouponApiFallback extends ApiFallback<UserCoupon> implements UserCouponApi {
}
