package org.siy.shop.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.siy.common.api.BaseApi;
import org.siy.shop.user.api.UserLevelApi;
import org.siy.shop.user.po.UserLevel;

@RestController
@RequestMapping("/userLevel")
public class UserLevelController extends BaseApi<UserLevel> implements UserLevelApi {
}
