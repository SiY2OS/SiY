package org.siy.shop.wechat.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties(prefix = "siy-wechat")
public class SiyWechatProperties {

    private List<String> loginInterceptorExcludePath;

    public List<String> getLoginInterceptorExcludePath() {
        return loginInterceptorExcludePath;
    }

    public void setLoginInterceptorExcludePath(List<String> loginInterceptorExcludePath) {
        this.loginInterceptorExcludePath = loginInterceptorExcludePath;
    }
}
