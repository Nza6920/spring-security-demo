package com.niu.security.core.social;

import org.springframework.social.security.SocialAuthenticationFilter;

/**
 * 社交登陆认证后置处理器
 *
 * @author [nza]
 * @version 1.0 2020/10/6
 * @createTime 2020/10/6
 */
public interface SocialAuthenticationFilterPostProcessor {

    void process(SocialAuthenticationFilter filter);
}
