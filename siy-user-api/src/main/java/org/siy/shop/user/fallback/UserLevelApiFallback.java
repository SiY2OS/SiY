package org.siy.shop.user.fallback;

import org.springframework.stereotype.Component;
import org.siy.common.fallback.ApiFallback;
import org.siy.shop.user.api.UserLevelApi;
import org.siy.shop.user.po.UserLevel;

@Component
public class UserLevelApiFallback extends ApiFallback<UserLevel> implements UserLevelApi {
}
