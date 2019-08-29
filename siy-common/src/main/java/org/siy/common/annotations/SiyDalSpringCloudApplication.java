package org.siy.common.annotations;

import org.siy.common.config.SiyAutoConfiguration;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

import java.lang.annotation.*;

/**
 * @author Ryan
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@SpringCloudApplication
@EnableWebMvc
@EnableSwagger2
@ComponentScan(value = "org.siy")
@EnableFeignClients("org.siy.shop.*.api")
@EnableCaching
@MapperScan(basePackages = "org.siy.shop.*.mapper")
@ImportAutoConfiguration(SiyAutoConfiguration.class)
public @interface SiyDalSpringCloudApplication {

}
