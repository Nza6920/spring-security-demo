package com.niu.security.core.properties;

/**
 * 浏览器模块配置
 *
 * @author [nza]
 * @version 1.0 2020/9/20
 * @createTime 2020/9/20
 */
public class BrowserProperties {

    /**
     * 登陆页
     */
    private String loginPage = "/my-login.html";

    /**
     * 登陆类型
     */
    private LoginType loginType = LoginType.JSON;

    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }

    public LoginType getLoginType() {
        return loginType;
    }

    public void setLoginType(LoginType loginType) {
        this.loginType = loginType;
    }
}
