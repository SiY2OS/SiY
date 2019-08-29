package org.siy.shop.wechat.service;

import org.siy.shop.user.query.CommentQuery;
import org.siy.shop.wechat.vo.CommentCountVO;
import org.siy.shop.wechat.vo.CommentResultVO;

import java.util.List;

public interface WechatCommentService {

    List<CommentResultVO> queryList(CommentQuery commentQuery);

    CommentCountVO countList(CommentQuery commentQuery);

}
