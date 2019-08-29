package org.siy.shop.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.siy.common.service.BaseService;
import org.siy.shop.user.mapper.CommentPictureMapper;
import org.siy.shop.user.po.CommentPicture;
import org.siy.shop.user.service.CommentPictureService;

import java.util.List;

@Service
public class CommentPictureServiceImpl extends BaseService<CommentPicture> implements CommentPictureService {

    @Autowired
    private CommentPictureMapper commentPictureMapper;

    @Override
    public List<String> queryPicUrlByCommentId(Integer commentId) {
        return commentPictureMapper.selectPicUrlByCommentId(commentId);
    }
}
