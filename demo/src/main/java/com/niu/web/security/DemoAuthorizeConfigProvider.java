package com.niu.web.security;

import com.niu.security.core.authorize.AuthorizeConfigProvider;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;

/**
 * Demo 权限配置
 *
 * @author [nza]
 * @version 1.0 2020/10/18
 * @createTime 14:49
 */
@Component
@Order(Integer.MAX_VALUE)
public class DemoAuthorizeConfigProvider implements AuthorizeConfigProvider {
    @Override
    public boolean config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config) {

        // 表达式校验
        config.anyRequest().access("@rbacService.hasPermission(request, authentication)");

        return true;
    }
}
