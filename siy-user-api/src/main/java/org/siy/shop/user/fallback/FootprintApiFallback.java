package org.siy.shop.user.fallback;

import org.springframework.stereotype.Component;
import org.siy.common.enums.ResultStatus;
import org.siy.common.fallback.ApiFallback;
import org.siy.common.utils.Result;
import org.siy.shop.user.api.FootprintApi;
import org.siy.shop.user.dto.GoodsFootprintDTO;
import org.siy.shop.user.po.Footprint;

import java.util.List;

@Component
public class FootprintApiFallback extends ApiFallback<Footprint> implements FootprintApi {

    @Override
    public Result<List<GoodsFootprintDTO>> queryGoodsFootprintByUserId(Integer userId) {
        return Result.failure(ResultStatus.REMOTE_SERVICE_ERROR);
    }
}
