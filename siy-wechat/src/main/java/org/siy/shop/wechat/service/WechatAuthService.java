package org.siy.shop.wechat.service;

import me.chanjar.weixin.common.error.WxErrorException;
import org.siy.shop.wechat.vo.LoginAuthParamVO;
import org.siy.shop.wechat.vo.LoginAuthResultVO;

public interface WechatAuthService {

    /**
     * 登陆接口
     *
     * @param loginAuthParamVO
     * @return
     */
    LoginAuthResultVO login(LoginAuthParamVO loginAuthParamVO) throws WxErrorException;

}
