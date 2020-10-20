package com.niu.security.core.authorize;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;

/**
 * 权限配置接口
 *
 * @author [nza]
 * @version 1.0 2020/10/18
 * @createTime 14:35
 */
public interface AuthorizeConfigProvider {

    boolean config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config);
}
