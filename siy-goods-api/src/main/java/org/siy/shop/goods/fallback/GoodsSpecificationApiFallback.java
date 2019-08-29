package org.siy.shop.goods.fallback;

import org.springframework.stereotype.Component;
import org.siy.common.enums.ResultStatus;
import org.siy.common.fallback.ApiFallback;
import org.siy.common.utils.Result;
import org.siy.shop.goods.api.GoodsSpecificationApi;
import org.siy.shop.goods.dto.GoodsSpecificationDTO;
import org.siy.shop.goods.po.GoodsSpecification;

import java.util.List;

@Component
public class GoodsSpecificationApiFallback extends ApiFallback<GoodsSpecification> implements GoodsSpecificationApi {
    @Override
    public Result<List<GoodsSpecificationDTO>> queryGoodsDetailSpecificationByGoodsId(Integer goodsId) {
        return Result.failure(ResultStatus.REMOTE_SERVICE_ERROR);
    }

    @Override
    public Result<List<String>> queryValueByGoodsIdAndIdIn(Integer goodsId, List<Integer> goodsSpecificationIds) {
        return Result.failure(ResultStatus.REMOTE_SERVICE_ERROR);
    }
}
