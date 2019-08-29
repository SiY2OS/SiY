package org.siy.shop.wechat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.siy.common.controller.BaseController;
import org.siy.common.utils.Result;
import org.siy.shop.wechat.service.WechatCatalogService;
import org.siy.shop.wechat.vo.CategoryIndexVO;
import org.siy.shop.wechat.vo.CategoryVO;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/wechat/catalog")
@Validated
public class WechatCatalogController extends BaseController {

    @Autowired
    private WechatCatalogService wechatCatalogService;

    @GetMapping("/index")
    public Result<CategoryIndexVO> index(Integer id) {
        return Result.success(wechatCatalogService.index(id));
    }

    @GetMapping("/current")
    public Result<CategoryVO> current(@NotNull @RequestParam("id") Integer id) {
        return Result.success(wechatCatalogService.current(id));
    }

}
