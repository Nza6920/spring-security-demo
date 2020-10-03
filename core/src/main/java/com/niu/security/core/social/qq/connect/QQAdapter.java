package com.niu.security.core.social.qq.connect;

import com.niu.security.core.social.qq.api.QQ;
import com.niu.security.core.social.qq.api.QQUserInfo;
import lombok.SneakyThrows;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;

/**
 * 适配APi
 *
 * @author [nza]
 * @version 1.0 2020/10/3
 * @createTime 2020/10/3
 */
public class QQAdapter implements ApiAdapter<QQ> {

    /**
     * 判断QQ服务是否正常
     * @param api
     * @return
     */
    @Override
    public boolean test(QQ api) {
        return true;
    }

    @Override
    public void setConnectionValues(QQ api, ConnectionValues values) {
        QQUserInfo userInfo = api.getUserInfo();

        values.setDisplayName(userInfo.getNickname());
        values.setImageUrl(userInfo.getFigureurl_qq_1());
        values.setProfileUrl(null);
        values.setProviderUserId(userInfo.getOpenId());
    }

    @Override
    public UserProfile fetchUserProfile(QQ api) {
        return null;
    }

    @Override
    public void updateStatus(QQ api, String message) {

    }
}
