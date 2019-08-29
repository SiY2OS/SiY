package org.siy.shop.wechat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.siy.common.controller.BaseController;
import org.siy.common.utils.Result;
import org.siy.shop.user.api.CollectApi;
import org.siy.shop.user.po.User;
import org.siy.shop.wechat.service.WechatCollectService;
import org.siy.shop.wechat.utils.JwtHelper;
import org.siy.shop.wechat.vo.CollectAddOrDeleteParamVO;
import org.siy.shop.wechat.vo.CollectAddOrDeleteResultVO;

@RestController
@RequestMapping("/wechat/collect")
public class WechatCollectController extends BaseController {

    @Autowired
    private CollectApi collectApi;

    @Autowired
    private WechatCollectService wechatCollectService;

    @PostMapping("/add-or-delete")
    public Result<CollectAddOrDeleteResultVO> addOrDelete(@RequestBody CollectAddOrDeleteParamVO collectAddOrDeleteParamDTO) {
        return Result.success(wechatCollectService.addOrDelete(collectAddOrDeleteParamDTO));
    }

    @GetMapping("/list")
    public Result queryList(Integer typeId) {
        User userInfo = JwtHelper.getUserInfo();
        return collectApi.queryGoodsCollectList(userInfo.getId());
    }

}
