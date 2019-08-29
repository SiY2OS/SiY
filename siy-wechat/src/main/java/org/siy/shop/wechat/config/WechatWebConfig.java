package org.siy.shop.wechat.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.siy.shop.wechat.interceptors.LoginInterceptor;


@Configuration
@EnableConfigurationProperties(SiyWechatProperties.class)
public class WechatWebConfig implements WebMvcConfigurer {

    private final SiyWechatProperties siyWechatProperties;

    public WechatWebConfig(SiyWechatProperties siyWechatProperties) {
        this.siyWechatProperties = siyWechatProperties;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")//拦截所有的路径
                .excludePathPatterns(siyWechatProperties.getLoginInterceptorExcludePath().toArray(new String[]{}));
    }
}
