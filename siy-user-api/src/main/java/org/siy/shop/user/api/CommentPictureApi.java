package org.siy.shop.user.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.siy.common.api.Api;
import org.siy.common.utils.Result;
import org.siy.shop.user.fallback.CommentPictureApiFallback;
import org.siy.shop.user.po.CommentPicture;

import java.util.List;

@FeignClient(value = "siy-user", path = "commentPicture", fallback = CommentPictureApiFallback.class)
public interface CommentPictureApi extends Api<CommentPicture> {

    @GetMapping("/queryPicUrlByCommentId")
    Result<List<String>> queryPicUrlByCommentId(@RequestParam("commentId") Integer commentId);

}
