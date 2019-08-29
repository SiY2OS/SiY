package org.siy.shop.user.fallback;

import org.springframework.stereotype.Component;
import org.siy.common.enums.ResultStatus;
import org.siy.common.fallback.ApiFallback;
import org.siy.common.utils.Result;
import org.siy.shop.user.api.CollectApi;
import org.siy.shop.user.dto.GoodsCollectDTO;
import org.siy.shop.user.po.Collect;

import java.util.List;

@Component
public class CollectApiFallback extends ApiFallback<Collect> implements CollectApi {

    @Override
    public Result<List<GoodsCollectDTO>> queryGoodsCollectList(Integer userId) {
        return Result.failure(ResultStatus.REMOTE_SERVICE_ERROR);
    }
}
