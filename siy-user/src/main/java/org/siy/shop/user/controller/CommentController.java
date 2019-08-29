package org.siy.shop.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.siy.common.api.BaseApi;
import org.siy.common.utils.Result;
import org.siy.shop.user.api.CommentApi;
import org.siy.shop.user.po.Comment;
import org.siy.shop.user.query.CommentQuery;
import org.siy.shop.user.service.CommentService;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController extends BaseApi<Comment> implements CommentApi {

    @Autowired
    private CommentService commentService;

    @Override
    public Result<List<Comment>> queryIfRequirePictureList(CommentQuery commentQuery) {
        return Result.success(commentService.queryIfRequirePictureList(commentQuery));
    }

    @Override
    public Result<Integer> countIfRequirePictureList(CommentQuery commentQuery) {
        return Result.success(commentService.countIfRequirePictureList(commentQuery));
    }
}
