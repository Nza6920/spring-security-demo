package com.niu.security.app.authentication.openid;

import com.niu.security.core.properties.SecurityConstants;
import org.bouncycastle.jcajce.util.ProviderJcaJceHelper;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.Assert;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * OpenId 登陆过滤器
 *
 * @author [nza]
 * @version 1.0 2020/10/6
 * @createTime 2020/10/6
 */
public class OpenIdAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    private String openIdParameter = SecurityConstants.DEFAULT_PARAMETER_NAME_OPENID;
    private String providerIdParameter = SecurityConstants.DEFAULT_PARAMETER_NAME_PROVIDER_ID;
    private boolean postOnly = true;

    private static final String POST = "POST";

    protected OpenIdAuthenticationFilter() {
        super(new AntPathRequestMatcher(SecurityConstants.DEFAULT_SIGN_IN_PROCESSING_URL_OPENID, "POST"));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        if (postOnly && !POST.equals(request.getMethod())) {
            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
        }

        String openid = obtainOpenId(request);
        String providerId = obtainProviderId(request);

        if (openid == null) {
            openid = "";
        }
        if (providerId == null) {
            providerId = "";
        }

        openid = openid.trim();
        providerId = providerId.trim();

        OpenIdAuthenticationToken authRequest = new OpenIdAuthenticationToken(openid, providerId);

        setDetails(request, authRequest);

        return this.getAuthenticationManager().authenticate(authRequest);
    }

    /**
     * 获取openId
     */
    protected String obtainOpenId(HttpServletRequest request) {
        return request.getParameter(openIdParameter);
    }

    /**
     * 获取提供商id
     */
    protected String obtainProviderId(HttpServletRequest request) {
        return request.getParameter(providerIdParameter);
    }

    /**
     * Provided so that subclasses may configure what is put into the
     * authentication request's details property.
     *
     * @param request     that an authentication request is being created for
     * @param authRequest the authentication request object that should have its details
     *                    set
     */
    protected void setDetails(HttpServletRequest request, OpenIdAuthenticationToken authRequest) {
        authRequest.setDetails(authenticationDetailsSource.buildDetails(request));
    }

    /**
     * Sets the parameter name which will be used to obtain the username from
     * the login request.
     *
     * @param openIdParameter the parameter name. Defaults to "username".
     */
    public void setOpenIdParameter(String openIdParameter) {
        Assert.hasText(openIdParameter, "Username parameter must not be empty or null");
        this.openIdParameter = openIdParameter;
    }

    /**
     * Defines whether only HTTP POST requests will be allowed by this filter.
     * If set to true, and an authentication request is received which is not a
     * POST request, an exception will be raised immediately and authentication
     * will not be attempted. The <tt>unsuccessfulAuthentication()</tt> method
     * will be called as if handling a failed authentication.
     * <p>
     * Defaults to <tt>true</tt> but may be overridden by subclasses.
     */
    public void setPostOnly(boolean postOnly) {
        this.postOnly = postOnly;
    }

    public final String getOpenIdParameter() {
        return openIdParameter;
    }

    public String getProviderIdParameter() {
        return providerIdParameter;
    }

    public void setProviderIdParameter(String providerIdParameter) {
        this.providerIdParameter = providerIdParameter;
    }
}
