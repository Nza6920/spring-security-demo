package com.niu.security.core.properties;

/**
 * 短信验证码配置
 *
 * @author [nza]
 * @version 1.0 2020/9/21
 * @createTime 2020/9/21
 */
public class SmsCodeProperties {

    /**
     * 长度
     */
    private Integer length = 6;

    /**
     * 过期时间
     */
    private Integer expireIn = 60;

    /**
     * 需要验证码验证的请求
     */
    private String url = "";

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getExpireIn() {
        return expireIn;
    }

    public void setExpireIn(Integer expireIn) {
        this.expireIn = expireIn;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
