package org.siy.shop.goods.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.siy.common.api.Api;
import org.siy.common.utils.Result;
import org.siy.shop.goods.fallback.CategoryApiFallback;
import org.siy.shop.goods.po.Category;

import java.util.List;

/**
 * @author Ryan
 */
@FeignClient(value = "siy-goods", path = "category", fallback = CategoryApiFallback.class)
public interface CategoryApi extends Api<Category> {

    @GetMapping("/queryIdsByParentId")
    Result<List<Integer>> queryIdsByParentId(@RequestBody Integer parentId);

    @GetMapping("/queryParentIdsByIdIn")
    Result<List<Integer>> queryParentIdsByIdIn(@RequestBody List<Integer> ids);

    @GetMapping("/queryByIdIn")
    Result<List<Category>> queryByIdIn(@RequestBody List<Integer> ids);

}
