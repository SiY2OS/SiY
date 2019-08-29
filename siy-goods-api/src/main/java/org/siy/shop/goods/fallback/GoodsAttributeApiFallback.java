package org.siy.shop.goods.fallback;

import org.springframework.stereotype.Component;
import org.siy.common.enums.ResultStatus;
import org.siy.common.fallback.ApiFallback;
import org.siy.common.utils.Result;
import org.siy.shop.goods.api.GoodsAttributeApi;
import org.siy.shop.goods.dto.GoodsAttributeDTO;
import org.siy.shop.goods.po.GoodsAttribute;

import java.util.List;

@Component
public class GoodsAttributeApiFallback extends ApiFallback<GoodsAttribute> implements GoodsAttributeApi {

    @Override
    public Result<List<GoodsAttributeDTO>> queryGoodsDetailAttributeByGoodsId(Integer goodsId) {
        return Result.failure(ResultStatus.REMOTE_SERVICE_ERROR);
    }
}
