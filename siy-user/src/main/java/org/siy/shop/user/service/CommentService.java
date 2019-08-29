package org.siy.shop.user.service;

import org.siy.common.service.IService;
import org.siy.shop.user.po.Comment;
import org.siy.shop.user.query.CommentQuery;

import java.util.List;

/**
 * @author Ryan
 */
public interface CommentService extends IService<Comment> {

    List<Comment> queryIfRequirePictureList(CommentQuery commentQuery);

    Integer countIfRequirePictureList(CommentQuery commentQuery);
}
