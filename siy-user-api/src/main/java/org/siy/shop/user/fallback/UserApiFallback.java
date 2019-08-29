package org.siy.shop.user.fallback;

import org.springframework.stereotype.Component;
import org.siy.common.fallback.ApiFallback;
import org.siy.shop.user.api.UserApi;
import org.siy.shop.user.po.User;

@Component
public class UserApiFallback extends ApiFallback<User> implements UserApi {
}
