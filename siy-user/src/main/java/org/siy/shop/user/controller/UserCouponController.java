package org.siy.shop.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.siy.common.api.BaseApi;
import org.siy.shop.user.api.UserCouponApi;
import org.siy.shop.user.po.UserCoupon;

@RestController
@RequestMapping("/UserCoupon")
public class UserCouponController extends BaseApi<UserCoupon> implements UserCouponApi {
}
