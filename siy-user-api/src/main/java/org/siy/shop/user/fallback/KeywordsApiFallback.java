package org.siy.shop.user.fallback;

import org.springframework.stereotype.Component;
import org.siy.common.enums.ResultStatus;
import org.siy.common.fallback.ApiFallback;
import org.siy.common.utils.Result;
import org.siy.shop.user.api.KeywordsApi;
import org.siy.shop.user.po.Keywords;

import java.util.List;

@Component
public class KeywordsApiFallback extends ApiFallback<Keywords> implements KeywordsApi {
    @Override
    public Result<List<String>> queryByKeyword(String keyword) {
        return Result.failure(ResultStatus.REMOTE_SERVICE_ERROR);
    }
}
