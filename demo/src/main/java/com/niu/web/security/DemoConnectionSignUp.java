package com.niu.web.security;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.stereotype.Component;

/**
 * 社交登陆新建用户逻辑实现类
 *
 * @author [nza]
 * @version 1.0 2020/10/4
 * @createTime 2020/10/4
 */
@Component
public class DemoConnectionSignUp implements ConnectionSignUp {
    @Override
    public String execute(Connection<?> connection) {

        // 根据社交用户信息默认创建用户, 并返回用户唯一标识
        return connection.getDisplayName();
    }
}
