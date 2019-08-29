package org.siy.shop.wechat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.siy.common.controller.BaseController;
import org.siy.common.utils.Result;
import org.siy.shop.user.api.CommentApi;
import org.siy.shop.user.query.CommentQuery;
import org.siy.shop.wechat.service.WechatCommentService;
import org.siy.shop.wechat.vo.CommentCountVO;
import org.siy.shop.wechat.vo.CommentPostVO;
import org.siy.shop.wechat.vo.CommentResultVO;

import java.util.List;

@RestController
@RequestMapping("/wechat/comment")
public class WechatCommentController extends BaseController {

    @Autowired
    private WechatCommentService wechatCommentService;

    @Autowired
    private CommentApi commentApi;

    @GetMapping("/list")
    public Result<List<CommentResultVO>> queryList(@Validated CommentQuery commentQuery) {
        return Result.success(wechatCommentService.queryList(commentQuery));
    }

    @GetMapping("/count")
    public Result<CommentCountVO> countList(@Validated CommentQuery commentQuery) {
        return Result.success(wechatCommentService.countList(commentQuery));
    }

    @PostMapping("post")
    public Result postComment(@RequestBody @Validated CommentPostVO commentPostDTO) {
        return commentApi.create(commentPostDTO.toPO());
    }

}
