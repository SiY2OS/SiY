package org.siy.shop.wechat.exception;

import me.chanjar.weixin.common.error.WxErrorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.siy.common.enums.ResultStatus;
import org.siy.common.exception.GlobalExceptionHandler;
import org.siy.common.utils.Result;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Ryan
 */
@ControllerAdvice
public class WechatExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 微信服务调用失败的异常拦截
     *
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(WxErrorException.class)
    public Result handleWxErrorException(HttpServletRequest request, WxErrorException e) {
        LOG.warn("execute method exception error.url is {}", request.getRequestURI(), e);
        return Result.failure(ResultStatus.WECHAT_SERVICE_ERROR.getCode(), e.getMessage());
    }

}
