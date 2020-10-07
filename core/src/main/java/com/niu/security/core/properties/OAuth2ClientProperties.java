package com.niu.security.core.properties;

/**
 * OAuth2 客户端配置类
 *
 * @author [nza]
 * @version 1.0 2020/10/7
 * @createTime 2020/10/7
 */
public class OAuth2ClientProperties {

    private String clientId;

    private String clientSecret;

    private int accessTokenValiditySeconds = 7200;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public int getAccessTokenValiditySeconds() {
        return accessTokenValiditySeconds;
    }

    public void setAccessTokenValiditySeconds(int accessTokenValiditySeconds) {
        this.accessTokenValiditySeconds = accessTokenValiditySeconds;
    }
}
