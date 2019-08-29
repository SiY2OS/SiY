package org.siy.shop.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.siy.common.api.BaseApi;
import org.siy.common.utils.Result;
import org.siy.shop.user.api.CommentPictureApi;
import org.siy.shop.user.po.CommentPicture;
import org.siy.shop.user.service.CommentPictureService;

import java.util.List;

@RestController
@RequestMapping("/commentPicture")
public class CommentPictureController extends BaseApi<CommentPicture> implements CommentPictureApi {

    @Autowired
    private CommentPictureService commentPictureService;

    @Override
    public Result<List<String>> queryPicUrlByCommentId(Integer commentId) {
        return Result.success(commentPictureService.queryPicUrlByCommentId(commentId));
    }
}
