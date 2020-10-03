package com.niu.security.core.social.qq.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.TokenStrategy;

import java.io.IOException;

/**
 * QQ实现
 *
 * @author [nza]
 * @version 1.0 2020/10/3
 * @createTime 2020/10/3
 */
@Slf4j
public class QQImpl extends AbstractOAuth2ApiBinding implements QQ {

    /**
     * 获取OPENID
     */
    private static final String URL_GET_OPEN_ID = "https://graph.qq.com/oauth2.0/me?access_token=%s";

    /**
     * 获取USER_INFO
     */
    private static final String URL_GET_USER_INFO = "https://graph.qq.com/user/get_user_info?oauth_consumer_key=%s&openid=%s";

    private ObjectMapper objectMapper = new ObjectMapper();

    private String appId;

    private String openId;

    public QQImpl(String accessToken, String appId) {
        // 将 accessToken 挂在请求参数上
        super(accessToken, TokenStrategy.ACCESS_TOKEN_PARAMETER);

        this.appId = appId;

        // 获取openID
        String url = String.format(URL_GET_OPEN_ID, accessToken);
        String res = getRestTemplate().getForObject(url, String.class);
        log.info("获取openId: {}", res);
        this.openId = StringUtils.substringBetween(res, "\"openid\":\"", "\"}");
    }

    @Override
    public QQUserInfo getUserInfo() {

        String url = String.format(URL_GET_USER_INFO, appId, openId);

        String res = getRestTemplate().getForObject(url, String.class);
        log.info("获取用户详情: {}", res);

        QQUserInfo userInfo = null;
        try {
            userInfo = objectMapper.readValue(res, QQUserInfo.class);
            userInfo.setOpenId(openId);
            return userInfo;
        } catch (IOException e) {
            throw new RuntimeException("获取用户信息失败");
        }
    }
}
