package org.siy.shop.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.siy.common.service.BaseService;
import org.siy.shop.user.mapper.CommentMapper;
import org.siy.shop.user.po.Comment;
import org.siy.shop.user.query.CommentQuery;
import org.siy.shop.user.service.CommentService;

import java.util.List;

/**
 * @author Ryan
 */
@Service
public class CommentServiceImpl extends BaseService<Comment> implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<Comment> queryIfRequirePictureList(CommentQuery commentQuery) {
        int limit = commentQuery.getPageSize();
        int offset = (commentQuery.getPageNum() - 1) * limit;
        return commentMapper.selectIfRequirePictureList(commentQuery, offset, limit);
    }

    @Override
    public Integer countIfRequirePictureList(CommentQuery commentQuery) {
        return commentMapper.countIfRequirePictureList(commentQuery);
    }
}
