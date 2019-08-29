package org.siy.shop.wechat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.siy.common.controller.BaseController;
import org.siy.common.utils.Result;
import org.siy.shop.user.api.AddressApi;
import org.siy.shop.user.po.Address;
import org.siy.shop.user.po.User;
import org.siy.shop.wechat.service.WechatAddressService;
import org.siy.shop.wechat.utils.JwtHelper;
import org.siy.shop.wechat.vo.AddressVO;

import java.util.List;

@RestController
@RequestMapping("/wechat/address")
@Validated
public class WechatAddressController extends BaseController {

    @Autowired
    private WechatAddressService addressService;

    @Autowired
    private AddressApi addressApi;

    @GetMapping("/list")
    public Result<List<AddressVO>> queryList() {
        return Result.success(addressService.queryDetailList());
    }

    @GetMapping("/detail")
    public Result<AddressVO> queryDetail(Integer id) {
        return Result.success(addressService.queryDetail(id));
    }

    @PostMapping("/save")
    public Result save(@Validated @RequestBody Address entity) {
        User userInfo = JwtHelper.getUserInfo();
        entity.setUserId(userInfo.getId());
        return addressApi.create(entity);
    }

    @PostMapping("/update")
    public Result update(@Validated @RequestBody Address entity) {
        User userInfo = JwtHelper.getUserInfo();
        entity.setUserId(userInfo.getId());
        addressApi.updateNotNull(entity);
        return Result.success();
    }

    @PostMapping("/delete")
    public Result delete(@Validated @RequestBody Address entity) {
        addressApi.deleteById(entity.getId());
        return Result.success();
    }
}
