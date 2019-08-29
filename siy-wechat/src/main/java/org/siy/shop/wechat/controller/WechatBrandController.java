package org.siy.shop.wechat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.siy.common.controller.BaseController;
import org.siy.common.utils.Result;
import org.siy.shop.goods.api.BrandApi;
import org.siy.shop.goods.po.Brand;

@RestController
@RequestMapping("/wechat/brand")
public class WechatBrandController extends BaseController {

    @Autowired
    private BrandApi brandApi;

    @GetMapping
    public Result<Brand> query(Integer id) {
        return brandApi.queryById(id);
    }

}
