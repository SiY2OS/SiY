package org.siy.shop.user.fallback;

import org.springframework.stereotype.Component;
import org.siy.common.enums.ResultStatus;
import org.siy.common.fallback.ApiFallback;
import org.siy.common.utils.Result;
import org.siy.shop.user.api.RegionApi;
import org.siy.shop.user.po.Region;

@Component
public class RegionApiFallback extends ApiFallback<Region> implements RegionApi {
    @Override
    public Result<String> queryNameById(Short id) {
        return Result.failure(ResultStatus.REMOTE_SERVICE_ERROR);
    }
}
