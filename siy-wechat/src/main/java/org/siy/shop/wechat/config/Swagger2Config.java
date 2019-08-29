package org.siy.shop.wechat.config;

import com.google.common.base.Predicate;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.AntPathMatcher;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spi.service.contexts.SecurityContextBuilder;
import springfox.documentation.spring.web.plugins.Docket;
import org.siy.shop.wechat.constants.WechatConstants;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableConfigurationProperties(SiyWechatProperties.class)
public class Swagger2Config {

    private SiyWechatProperties siyWechatProperties;

    public Swagger2Config(SiyWechatProperties siyWechatProperties) {
        this.siyWechatProperties = siyWechatProperties;
    }

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.siy.shop.wechat.controller"))
                .paths(PathSelectors.any())
                .build()
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("微信小程序端接口文档")
                .description("SiY Shop | 微信小程序综合商城")
                .termsOfServiceUrl("http://192.168.10.245/chit/shop")
                .version("1.0")
                .build();
    }

    private List<ApiKey> securitySchemes() {
        return Arrays.asList(new ApiKey(WechatConstants.JWT_KEY_NAME, WechatConstants.JWT_KEY_NAME, "header"));
    }

    private List<SecurityContext> securityContexts() {
        SecurityContextBuilder builder = SecurityContext.builder().securityReferences(securityReferences());
        builder.forPaths(forExcludeAntPaths(siyWechatProperties.getLoginInterceptorExcludePath()));
        return Arrays.asList(builder.build());
    }

    /**
     * 匹配登陆拦截器过滤地址
     *
     * @param antPatterns - ant Patterns
     * @return predicate that matches a particular ant pattern
     */
    private Predicate<String> forExcludeAntPaths(final List<String> antPatterns) {
        return (input) -> {
            AntPathMatcher matcher = new AntPathMatcher();
            return !antPatterns.stream().anyMatch(antPattern -> matcher.match(antPattern, input));
        };
    }

    private List<SecurityReference> securityReferences() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        return Arrays.asList(
                new SecurityReference(WechatConstants.JWT_KEY_NAME, new AuthorizationScope[]{authorizationScope}));
    }

}
