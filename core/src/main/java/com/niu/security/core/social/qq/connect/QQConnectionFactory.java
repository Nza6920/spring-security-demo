package com.niu.security.core.social.qq.connect;

import com.niu.security.core.social.qq.api.QQ;
import org.springframework.social.connect.support.OAuth2ConnectionFactory;

/**
 * QQConnectionFactory
 *
 * @author [nza]
 * @version 1.0 2020/10/3
 * @createTime 2020/10/3
 */
public class QQConnectionFactory extends OAuth2ConnectionFactory<QQ> {

    /**
     * Create a {@link OAuth2ConnectionFactory}.
     *
     * @param providerId the provider id e.g. "facebook"
     * @param appId
     * @param appSecret
     */
    public QQConnectionFactory(String providerId, String appId, String appSecret) {
        super(providerId, new QQServiceProvider(appId, appSecret), new QQAdapter());
    }
}
