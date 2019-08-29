package org.siy.shop.wechat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.siy.common.controller.BaseController;
import org.siy.common.utils.Result;
import org.siy.shop.wechat.service.WechatHomeService;
import org.siy.shop.wechat.vo.HomeIndexVO;

/**
 * @author Ryan
 */
@RestController
@RequestMapping("/wechat/home")
public class WechatHomeController extends BaseController {

    @Autowired
    private WechatHomeService wechatHomeService;


    @GetMapping("/index")
    public Result<HomeIndexVO> index() {
        return Result.success(wechatHomeService.index());
    }

}
