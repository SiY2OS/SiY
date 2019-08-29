package org.siy.shop.wechat.vo;


import org.siy.shop.user.po.User;

public class LoginAuthResultVO {

    private String token;

    private User userInfo;

    public LoginAuthResultVO() {
    }

    public LoginAuthResultVO(String token, User userInfo) {
        this.token = token;
        this.userInfo = userInfo;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(User userInfo) {
        this.userInfo = userInfo;
    }
}
