package com.niu.security.core.social;

import org.springframework.social.security.SocialAuthenticationFilter;
import org.springframework.social.security.SpringSocialConfigurer;

/**
 * CustomSpringSocialConfigurer
 *
 * @author [nza]
 * @version 1.0 2020/10/3
 * @createTime 2020/10/3
 */
public class CustomSpringSocialConfigurer extends SpringSocialConfigurer {

    private String filterProcessesUrl;

    public CustomSpringSocialConfigurer(String filterProcessesUrl) {
        this.filterProcessesUrl = filterProcessesUrl;
    }

    @Override
    protected <T> T postProcess(T object) {

        SocialAuthenticationFilter filter = (SocialAuthenticationFilter) super.postProcess(object);
        filter.setFilterProcessesUrl(filterProcessesUrl);
        return (T) filter;
    }
}
