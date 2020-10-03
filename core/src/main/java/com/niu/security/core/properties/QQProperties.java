package com.niu.security.core.properties;

import org.springframework.boot.autoconfigure.social.SocialProperties;

/**
 * QQ登陆配置
 *
 * @author [nza]
 * @version 1.0 2020/10/3
 * @createTime 2020/10/3
 */
public class QQProperties extends SocialProperties {

    private String providerId = "qq";

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }
}
