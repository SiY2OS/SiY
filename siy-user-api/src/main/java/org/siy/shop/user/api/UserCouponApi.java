package org.siy.shop.user.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.siy.common.api.Api;
import org.siy.shop.user.fallback.UserCouponApiFallback;
import org.siy.shop.user.po.UserCoupon;

@FeignClient(value = "siy-user", path = "userCoupon", fallback = UserCouponApiFallback.class)
public interface UserCouponApi extends Api<UserCoupon> {
}
