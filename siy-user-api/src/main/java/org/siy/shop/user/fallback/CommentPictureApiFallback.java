package org.siy.shop.user.fallback;

import org.springframework.stereotype.Component;
import org.siy.common.enums.ResultStatus;
import org.siy.common.fallback.ApiFallback;
import org.siy.common.utils.Result;
import org.siy.shop.user.api.CommentPictureApi;
import org.siy.shop.user.po.CommentPicture;

import java.util.List;

@Component
public class CommentPictureApiFallback extends ApiFallback<CommentPicture> implements CommentPictureApi {
    @Override
    public Result<List<String>> queryPicUrlByCommentId(Integer commentId) {
        return Result.failure(ResultStatus.REMOTE_SERVICE_ERROR);
    }
}
