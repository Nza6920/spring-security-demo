package com.niu.security.app;

import com.niu.security.app.social.AppSignUpUtils;
import com.niu.security.core.support.SocialUserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;

/**
 * App 社交登陆
 *
 * @author [nza]
 * @version 1.0 2020/10/6
 * @createTime 2020/10/6
 */
@RestController
public class AppSecurityController {

    @Autowired
    private ProviderSignInUtils providerSignInUtils;

    @Autowired
    private AppSignUpUtils appSignUpUtils;

    @GetMapping("/social/signUp")
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public SocialUserInfo getSocialUserInfo(HttpServletRequest request) {
        SocialUserInfo userInfo = new SocialUserInfo();

        // 先从 session 中获取到 social 数据
        Connection<?> connection = providerSignInUtils.getConnectionFromSession(new ServletWebRequest(request));
        userInfo.setProviderId(connection.getKey().getProviderId())
                .setProviderUserId(connection.getKey().getProviderUserId())
                .setHeadImg(connection.getImageUrl())
                .setNickname(connection.getDisplayName());

        // 转存到redis中
        appSignUpUtils.saveConnectionData(new ServletWebRequest(request), connection.createData());

        return userInfo;
    }
}
