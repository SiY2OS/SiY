package org.siy.shop.wechat.service.impl;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.siy.common.utils.Criteria;
import org.siy.common.utils.EnumUtils;
import org.siy.common.utils.JsonUtils;
import org.siy.common.utils.WebUtil;
import org.siy.shop.user.api.UserApi;
import org.siy.shop.user.enums.GenderEnum;
import org.siy.shop.user.po.User;
import org.siy.shop.wechat.config.WxMaConfiguration;
import org.siy.shop.wechat.constants.WechatConstants;
import org.siy.shop.wechat.service.WechatAuthService;
import org.siy.shop.wechat.utils.JwtHelper;
import org.siy.shop.wechat.vo.LoginAuthParamVO;
import org.siy.shop.wechat.vo.LoginAuthResultVO;

import java.util.Date;
import java.util.UUID;

@Service
public class WechatAuthServiceImpl implements WechatAuthService {

    @Value("${siy.wx.miniapp.appid}")
    private String appid;

    @Autowired
    private UserApi userApi;

    @Override
    public LoginAuthResultVO login(LoginAuthParamVO loginAuthParamVO) throws WxErrorException {
        final WxMaService wxService = WxMaConfiguration.getMaService(appid);
        WxMaJscode2SessionResult sessionInfo = wxService.getUserService().getSessionInfo(loginAuthParamVO.getCode());
        LoginAuthParamVO.UserInfoX.UserInfo userInfo = loginAuthParamVO.getUserInfo().getUserInfo();
        //根据openId查询用户是否已经注册
        User user = userApi.queryOneByCriteria(Criteria.of(User.class).andEqualTo(User::getWechatOpenId, sessionInfo.getOpenid())).getData();
        if (user == null) {
            //注册
            user = new User();
            user.setUsername("微信用户" + UUID.randomUUID().toString());
            user.setPassword("");
            user.setRegisterTime(new Date());
            user.setRegisterIp(WebUtil.getInstance().getIpAddress());
            user.setMobile("");
            user.setWechatOpenId(sessionInfo.getOpenid());
            user.setAvatar(userInfo.getAvatarUrl());
            user.setGender(EnumUtils.getEnum(GenderEnum.class, userInfo.getGender()));
            user.setNickname(userInfo.getNickName());
            userApi.create(user);
        }
        //查询用户信息
        User newUser = userApi.queryOneByCriteria(Criteria.of(User.class).andEqualTo(User::getWechatOpenId, sessionInfo.getOpenid())).getData();
        newUser.setLastLoginTime(new Date());
        newUser.setLastLoginIp(WebUtil.getInstance().getIpAddress());
        //更新登陆信息
        userApi.updateNotNull(newUser);
        //生成token
        String token = JwtHelper.createJWT("wechat", JsonUtils.toJson(newUser), WechatConstants.JWT_TTL);
        return new LoginAuthResultVO(token, newUser);
    }
}
