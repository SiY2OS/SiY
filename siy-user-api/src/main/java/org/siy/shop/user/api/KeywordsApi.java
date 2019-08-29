package org.siy.shop.user.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.siy.common.api.Api;
import org.siy.common.utils.Result;
import org.siy.shop.user.fallback.KeywordsApiFallback;
import org.siy.shop.user.po.Keywords;

import java.util.List;

@FeignClient(value = "siy-user", path = "keywords", fallback = KeywordsApiFallback.class)
public interface KeywordsApi extends Api<Keywords> {

    @GetMapping("/queryByKeyword")
    Result<List<String>> queryByKeyword(@RequestParam("keyword") String keyword);
}
