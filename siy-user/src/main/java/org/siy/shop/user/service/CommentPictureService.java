package org.siy.shop.user.service;

import org.siy.common.service.IService;
import org.siy.shop.user.po.CommentPicture;

import java.util.List;

public interface CommentPictureService extends IService<CommentPicture> {

    List<String> queryPicUrlByCommentId(Integer commentId);

}
