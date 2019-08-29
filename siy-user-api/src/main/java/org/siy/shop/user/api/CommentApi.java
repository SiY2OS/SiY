package org.siy.shop.user.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.siy.common.api.Api;
import org.siy.common.utils.Result;
import org.siy.shop.user.fallback.CommentApiFallback;
import org.siy.shop.user.po.Comment;
import org.siy.shop.user.query.CommentQuery;

import java.util.List;

@FeignClient(value = "siy-user", path = "comment", fallback = CommentApiFallback.class)
public interface CommentApi extends Api<Comment> {

    @GetMapping("/queryIfRequirePictureList")
    Result<List<Comment>> queryIfRequirePictureList(@RequestBody CommentQuery commentQuery);

    @GetMapping("/countIfRequirePictureList")
    Result<Integer> countIfRequirePictureList(@RequestBody CommentQuery commentQuery);

}
