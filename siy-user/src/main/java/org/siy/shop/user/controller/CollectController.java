package org.siy.shop.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.siy.common.api.BaseApi;
import org.siy.common.utils.Result;
import org.siy.shop.user.api.CollectApi;
import org.siy.shop.user.dto.GoodsCollectDTO;
import org.siy.shop.user.po.Collect;
import org.siy.shop.user.service.CollectService;

import java.util.List;

@RestController
@RequestMapping("/collect")
public class CollectController extends BaseApi<Collect> implements CollectApi {

    @Autowired
    private CollectService collectService;

    @Override
    public Result<List<GoodsCollectDTO>> queryGoodsCollectList(Integer userId) {
        return Result.success(collectService.queryGoodsCollectList(userId));
    }
}
