package org.siy.shop.wechat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.siy.common.controller.BaseController;
import org.siy.common.utils.Result;
import org.siy.shop.user.api.FootprintApi;
import org.siy.shop.user.dto.GoodsFootprintDTO;
import org.siy.shop.user.po.Footprint;
import org.siy.shop.user.po.User;
import org.siy.shop.wechat.service.WechatFootprintService;
import org.siy.shop.wechat.utils.JwtHelper;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/wechat/footprint")
@Validated
public class WechatFootprintController extends BaseController {

    @Autowired
    private FootprintApi footprintApi;

    @Autowired
    private WechatFootprintService wechatFootprintService;

    @GetMapping("/list")
    public Result<List<List<GoodsFootprintDTO>>> queryGoodsFootprintList() {
        return Result.success(wechatFootprintService.queryGoodsFootprintTimeLine());
    }

    @PostMapping("/delete")
    public Result deleteGoodsFootprint(@NotNull Integer goodsId) {
        User userInfo = JwtHelper.getUserInfo();
        return footprintApi.delete(new Footprint().setGoodsId(goodsId).setUserId(userInfo.getId()));
    }

}
