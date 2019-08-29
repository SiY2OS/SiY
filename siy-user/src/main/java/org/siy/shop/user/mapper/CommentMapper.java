package org.siy.shop.user.mapper;

import org.siy.common.utils.MyMapper;
import org.siy.shop.user.po.Comment;
import org.siy.shop.user.query.CommentQuery;

import java.util.List;

public interface CommentMapper extends MyMapper<Comment> {

    /**
     * 查询有图片的评论
     *
     * @return
     */
    List<Comment> selectIfRequirePictureList(CommentQuery commentQuery, int offset, int limit);

    Integer countIfRequirePictureList(CommentQuery commentQuery);

}
