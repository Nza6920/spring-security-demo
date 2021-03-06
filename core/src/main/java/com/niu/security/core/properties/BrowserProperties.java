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

    private String signUpPage = "/my-signUp.html";

    private String signOutUrl;

    /**
     * 记住我时间
     */
    private int rememberMeSeconds = 3600;

    /**
     * 登陆类型
     */
    private LoginType loginType = LoginType.JSON;


    /**
     * session 相关
     */
    private SessionProperties session = new SessionProperties();

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

    public int getRememberMeSeconds() {
        return rememberMeSeconds;
    }

    public void setRememberMeSeconds(int rememberMeSeconds) {
        this.rememberMeSeconds = rememberMeSeconds;
    }

    public String getSignUpPage() {
        return signUpPage;
    }

    public void setSignUpPage(String signUpPage) {
        this.signUpPage = signUpPage;
    }

    public SessionProperties getSession() {
        return session;
    }

    public void setSession(SessionProperties session) {
        this.session = session;
    }

    public String getSignOutUrl() {
        return signOutUrl;
    }

    public void setSignOutUrl(String signOutUrl) {
        this.signOutUrl = signOutUrl;
    }
}
