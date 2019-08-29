package org.siy.shop.wechat.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.siy.common.enums.ResultStatus;
import org.siy.common.exception.BizException;
import org.siy.common.utils.JsonUtils;
import org.siy.common.utils.Result;
import org.siy.shop.user.api.UserApi;
import org.siy.shop.user.po.User;
import org.siy.shop.wechat.constants.WechatConstants;
import org.siy.shop.wechat.utils.JwtHelper;

/**
 * @author Ryan
 */
@Api(tags = "开发人员测试接口，包括获取Token等，只在dev环境可见")
@RestController
@RequestMapping("/wechat/dev")
@ConditionalOnProperty(name = "spring.cloud.config.profile", havingValue = "dev")
public class WechatDevController {

  @Autowired
  private UserApi userApi;

  @PostMapping("{userId}/token")
  @ApiOperation("【慎用】根据id获取Token用于测试")
  public Result<String> getTokenByUserId(@PathVariable("userId") String userId) {
    User user = userApi.queryById(userId).getData();
    if (user == null) {
      throw new BizException(ResultStatus.RECORD_NOT_EXIST);
    }
    //生成token
    String token = JwtHelper.createJWT("wechat", JsonUtils.toJson(user), WechatConstants.JWT_TTL);
    return Result.success(token);
  }

}
