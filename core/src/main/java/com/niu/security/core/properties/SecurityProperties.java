package com.niu.security.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 参数配置类
 *
 * @author [nza]
 * @version 1.0 2020/9/20
 * @createTime 2020/9/20
 */
@ConfigurationProperties(prefix = "niu.security")
@Component
public class SecurityProperties {

    /**
     * 浏览器相关配置
     */
    private BrowserProperties browser = new BrowserProperties();

    /**
     * 验证码相关配置
     */
    private ValidateCodeProperties code = new ValidateCodeProperties();

    /**
     * 三方登陆相关配置
     */
    private SocialProperties social = new SocialProperties();

  public BrowserProperties getBrowser() {
        return browser;
    }

    public void setBrowser(BrowserProperties browser) {
        this.browser = browser;
    }

    public ValidateCodeProperties getCode() {
        return code;
    }

    public void setCode(ValidateCodeProperties code) {
        this.code = code;
    }

    public SocialProperties getSocial() {
        return social;
    }

    public void setSocial(SocialProperties social) {
        this.social = social;
    }
}
