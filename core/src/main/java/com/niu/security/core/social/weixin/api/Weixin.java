package com.niu.security.core.social.weixin.api;

/**
 * 微信详情接口
 *
 * @author [nza]
 * @version 1.0 2020/10/4
 * @createTime 2020/10/4
 */
public interface Weixin {

    /**
     * 获取微信用户详情
     * @param openId
     * @return
     */
    WeixinUserInfo getUserInfo(String openId);
}
