package org.siy.shop.wechat.controller;

import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.siy.common.controller.BaseController;
import org.siy.common.utils.Result;
import org.siy.shop.wechat.service.WechatAuthService;
import org.siy.shop.wechat.vo.LoginAuthParamVO;
import org.siy.shop.wechat.vo.LoginAuthResultVO;

@RestController
@RequestMapping("/wechat/auth")
public class WechatAuthController extends BaseController {

    @Autowired
    private WechatAuthService wechatAuthService;

    @PostMapping("/login")
    public Result<LoginAuthResultVO> loginByWeixin(@RequestBody @Validated LoginAuthParamVO loginAuthParamVO) throws WxErrorException {
        return Result.success(wechatAuthService.login(loginAuthParamVO));
    }

}
