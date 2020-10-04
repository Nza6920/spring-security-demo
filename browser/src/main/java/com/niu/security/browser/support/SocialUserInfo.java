package com.niu.security.browser.support;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 社会用户详情
 *
 * @author [nza]
 * @version 1.0 2020/10/4
 * @createTime 2020/10/4
 */
@Data
@Accessors(chain = true)
public class SocialUserInfo {

    private String providerId;

    private String providerUserId;

    private String nickname;

    private String headImg;

}
