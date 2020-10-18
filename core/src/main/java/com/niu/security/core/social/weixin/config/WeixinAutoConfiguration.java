package com.niu.security.core.social.weixin.config;


import com.niu.security.core.properties.SecurityProperties;
import com.niu.security.core.properties.WeixinProperties;
import com.niu.security.core.social.CustomConnectView;
import com.niu.security.core.social.weixin.connect.WeixinConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.social.SocialAutoConfigurerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.ConnectionFactory;
import org.springframework.web.servlet.View;

/**
 * 微信登录配置
 *
 * @author nza
 */
@Configuration
@ConditionalOnProperty(prefix = "niu.security.social.weixin", name = "app-id")
public class WeixinAutoConfiguration extends SocialAutoConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    protected ConnectionFactory<?> createConnectionFactory() {
        WeixinProperties weixinConfig = securityProperties.getSocial().getWeixin();
        return new WeixinConnectionFactory(weixinConfig.getProviderId(), weixinConfig.getAppId(),
                weixinConfig.getAppSecret());
    }

    @Bean("connect/weixinConnected")
    @ConditionalOnMissingBean(name = "connect/weixinConnected")
    public View weixinConnectedView() {
        return new CustomConnectView();
    }
}
