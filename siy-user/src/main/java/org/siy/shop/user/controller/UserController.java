package org.siy.shop.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.siy.common.api.BaseApi;
import org.siy.shop.user.api.UserApi;
import org.siy.shop.user.po.User;

@RestController
@RequestMapping("/user")
public class UserController extends BaseApi<User> implements UserApi {
}
