package org.siy.shop.user.fallback;

import org.springframework.stereotype.Component;
import org.siy.common.enums.ResultStatus;
import org.siy.common.fallback.ApiFallback;
import org.siy.common.utils.Result;
import org.siy.shop.user.api.CommentApi;
import org.siy.shop.user.po.Comment;
import org.siy.shop.user.query.CommentQuery;

import java.util.List;

@Component
public class CommentApiFallback extends ApiFallback<Comment> implements CommentApi {

    @Override
    public Result<List<Comment>> queryIfRequirePictureList(CommentQuery commentQuery) {
        return Result.failure(ResultStatus.REMOTE_SERVICE_ERROR);
    }

    @Override
    public Result<Integer> countIfRequirePictureList(CommentQuery commentQuery) {
        return Result.failure(ResultStatus.REMOTE_SERVICE_ERROR);
    }
}
