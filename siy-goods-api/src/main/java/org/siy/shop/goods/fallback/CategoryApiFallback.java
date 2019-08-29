package org.siy.shop.goods.fallback;

import org.springframework.stereotype.Component;
import org.siy.common.enums.ResultStatus;
import org.siy.common.fallback.ApiFallback;
import org.siy.common.utils.Result;
import org.siy.shop.goods.api.CategoryApi;
import org.siy.shop.goods.po.Category;

import java.util.List;

@Component
public class CategoryApiFallback extends ApiFallback<Category> implements CategoryApi {
    @Override
    public Result<List<Integer>> queryIdsByParentId(Integer parentId) {
        return Result.failure(ResultStatus.REMOTE_SERVICE_ERROR);
    }

    @Override
    public Result<List<Integer>> queryParentIdsByIdIn(List<Integer> ids) {
        return Result.failure(ResultStatus.REMOTE_SERVICE_ERROR);
    }

    @Override
    public Result<List<Category>> queryByIdIn(List<Integer> ids) {
        return Result.failure(ResultStatus.REMOTE_SERVICE_ERROR);
    }
}
