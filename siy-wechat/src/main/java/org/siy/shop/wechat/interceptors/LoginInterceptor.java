package org.siy.shop.wechat.interceptors;

import io.jsonwebtoken.Claims;
import org.springframework.web.servlet.HandlerInterceptor;
import org.siy.common.enums.ResultStatus;
import org.siy.common.exception.BizException;
import org.siy.common.utils.StringUtils;
import org.siy.shop.wechat.constants.WechatConstants;
import org.siy.shop.wechat.utils.JwtHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Ryan
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader(WechatConstants.JWT_KEY_NAME);
        if (StringUtils.isBlank(token)) {
            throw new BizException(ResultStatus.WECHAT_LOGIN_ERROR);
        }
        Claims claims = JwtHelper.parseJWT(token);
        JwtHelper.setCurrentClaims(claims);
        return true;
    }
}
