package org.siy.shop.user.mapper;

import org.siy.common.utils.MyMapper;
import org.siy.shop.user.po.CommentPicture;

import java.util.List;

public interface CommentPictureMapper extends MyMapper<CommentPicture> {

    List<String> selectPicUrlByCommentId(Integer commentId);

}
