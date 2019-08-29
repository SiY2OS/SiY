package org.siy.shop.wechat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.siy.common.controller.BaseController;
import org.siy.common.utils.Result;
import org.siy.shop.user.api.RegionApi;
import org.siy.shop.user.po.Region;

import java.util.List;

@RestController
@RequestMapping("/wechat/region")
public class WechatRegionController extends BaseController {

    @Autowired
    private RegionApi regionApi;

    @GetMapping("/list")
    public Result<List<Region>> queryList(Short parentId) {
        return regionApi.queryList(new Region().setParentId(parentId));
    }

}
