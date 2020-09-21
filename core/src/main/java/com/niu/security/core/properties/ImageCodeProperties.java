package com.niu.security.core.properties;

/**
 * 图形验证码配置
 *
 * @author [nza]
 * @version 1.0 2020/9/21
 * @createTime 2020/9/21
 */
public class ImageCodeProperties {

    /**
     * 宽
     */
    private Integer width = 67;

    /**
     * 高
     */
    private Integer height = 23;

    /**
     * 长度
     */
    private Integer length = 4;

    /**
     * 过期时间
     */
    private Integer expireIn = 60;

    /**
     * 需要验证码验证的请求
     */
    private String url = "";

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

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
