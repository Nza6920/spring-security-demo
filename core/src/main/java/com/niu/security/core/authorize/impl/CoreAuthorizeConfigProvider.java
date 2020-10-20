package com.niu.security.core.authorize.impl;

import com.niu.security.core.authorize.AuthorizeConfigProvider;
import com.niu.security.core.properties.SecurityConstants;
import com.niu.security.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;

/**
 * 权限核心配置类
 *
 * @author [nza]
 * @version 1.0 2020/10/18
 * @createTime 14:36
 */
@Component
@Order(Integer.MIN_VALUE)
public class CoreAuthorizeConfigProvider implements AuthorizeConfigProvider {

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public boolean config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config) {
        config.antMatchers(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL,
                SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_MOBILE,
                securityProperties.getBrowser().getLoginPage(),
                SecurityConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX + "/*",
                securityProperties.getBrowser().getSignUpPage(),
                "/user/register",
                "/session/invalid")
        .permitAll();

        return false;
    }
}
