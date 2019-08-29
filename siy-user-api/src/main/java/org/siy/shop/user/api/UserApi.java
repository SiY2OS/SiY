package org.siy.shop.user.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.siy.common.api.Api;
import org.siy.shop.user.fallback.UserApiFallback;
import org.siy.shop.user.po.User;

@FeignClient(value = "siy-user", path = "user", fallback = UserApiFallback.class)
public interface UserApi extends Api<User> {
}
