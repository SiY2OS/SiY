package org.siy.shop.user.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.siy.common.api.Api;
import org.siy.shop.user.fallback.UserLevelApiFallback;
import org.siy.shop.user.po.UserLevel;

@FeignClient(value = "siy-user", path = "userLevel", fallback = UserLevelApiFallback.class)
public interface UserLevelApi extends Api<UserLevel> {
}
