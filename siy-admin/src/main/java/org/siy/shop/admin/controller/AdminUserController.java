package org.siy.shop.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.siy.common.controller.BaseController;
import org.siy.common.utils.Criteria;
import org.siy.common.utils.Result;
import org.siy.shop.user.api.UserApi;
import org.siy.shop.user.api.UserLevelApi;
import org.siy.shop.user.enums.GenderEnum;
import org.siy.shop.user.po.User;
import org.siy.shop.user.po.UserLevel;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Ryan
 */
@RestController
@RequestMapping("/admin/user")
public class AdminUserController extends BaseController {

    @Autowired
    private UserApi userApi;

    @Autowired
    private UserLevelApi userLevelApi;

    @GetMapping("/list")
    public Result<List<User>> queryList() {
        return userApi.queryByCriteria(Criteria.of(User.class))
                .addExtra("userLevel", userLevelApi.queryAll().getData().stream().collect(Collectors.toMap(UserLevel::getId, UserLevel::getName)))
                .addExtra("gender", Arrays.stream(GenderEnum.values()).collect(Collectors.toMap(e -> e, GenderEnum::getName)));
    }

}
