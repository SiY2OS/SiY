package org.siy.shop.wechat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.siy.shop.user.api.CommentApi;
import org.siy.shop.user.api.CommentPictureApi;
import org.siy.shop.user.api.UserApi;
import org.siy.shop.user.po.User;
import org.siy.shop.user.query.CommentQuery;
import org.siy.shop.wechat.service.WechatCommentService;
import org.siy.shop.wechat.vo.CommentCountVO;
import org.siy.shop.wechat.vo.CommentResultVO;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WechatCommentServiceImpl implements WechatCommentService {

    @Autowired
    private UserApi userApi;

    @Autowired
    private CommentApi commentApi;

    @Autowired
    private CommentPictureApi commentPictureApi;

    @Override
    public List<CommentResultVO> queryList(CommentQuery commentQuery) {
        List<CommentResultVO> commentResultList = commentApi.queryIfRequirePictureList(commentQuery).getData().stream()
                .map(CommentResultVO::new)
                .collect(Collectors.toList());
        for (CommentResultVO commentResultDTO : commentResultList) {
            commentResultDTO.setPicList(commentPictureApi.queryPicUrlByCommentId(commentResultDTO.getId()).getData());
            User user = Optional.ofNullable(userApi.queryById(commentResultDTO.getUserId()).getData()).orElseGet(() -> new User());
            commentResultDTO.setUserInfo(new CommentResultVO.UserInfoVO(user));
        }
        return commentResultList;
    }

    @Override
    public CommentCountVO countList(CommentQuery commentQuery) {
        Integer hasPicCount = commentApi.countIfRequirePictureList(commentQuery.setRequirePicture(true)).getData();
        Integer allCount = commentApi.countIfRequirePictureList(commentQuery.setRequirePicture(false)).getData();
        return new CommentCountVO(allCount, hasPicCount);
    }
}
