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

    private SocialAuthenticationFilterPostProcessor postProcessor;

    public CustomSpringSocialConfigurer(String filterProcessesUrl) {
        this.filterProcessesUrl = filterProcessesUrl;
    }

    public CustomSpringSocialConfigurer(String filterProcessesUrl, SocialAuthenticationFilterPostProcessor postProcessor) {
        this.filterProcessesUrl = filterProcessesUrl;
        this.postProcessor = postProcessor;
    }

    @Override
    protected <T> T postProcess(T object) {

        SocialAuthenticationFilter filter = (SocialAuthenticationFilter) super.postProcess(object);
        filter.setFilterProcessesUrl(filterProcessesUrl);
        if (this.postProcessor != null) {
            postProcessor.process(filter);
        }
        return (T) filter;
    }

    public SocialAuthenticationFilterPostProcessor getPostProcessor() {
        return postProcessor;
    }

    public void setPostProcessor(SocialAuthenticationFilterPostProcessor postProcessor) {
        this.postProcessor = postProcessor;
    }
}
