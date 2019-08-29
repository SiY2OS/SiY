package org.siy.shop.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.siy.common.api.BaseApi;
import org.siy.common.utils.Result;
import org.siy.shop.user.api.KeywordsApi;
import org.siy.shop.user.po.Keywords;
import org.siy.shop.user.service.KeywordsService;

import java.util.List;

@RestController
@RequestMapping("/keywords")
public class KeywordsController extends BaseApi<Keywords> implements KeywordsApi {

    @Autowired
    private KeywordsService keywordsService;

    @Override
    public Result<List<String>> queryByKeyword(String keyword) {
        return Result.success(keywordsService.queryByKeyword(keyword));
    }
}
