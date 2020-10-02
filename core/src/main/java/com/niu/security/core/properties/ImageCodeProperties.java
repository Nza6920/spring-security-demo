package com.niu.security.core.properties;

/**
 * 图形验证码配置
 *
 * @author [nza]
 * @version 1.0 2020/9/21
 * @createTime 2020/9/21
 */
public class ImageCodeProperties extends SmsCodeProperties {

    public ImageCodeProperties() {
        setLength(4);
    }

    /**
     * 宽
     */
    private Integer width = 40;

    /**
     * 高
     */
    private Integer height = 30;


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
}
