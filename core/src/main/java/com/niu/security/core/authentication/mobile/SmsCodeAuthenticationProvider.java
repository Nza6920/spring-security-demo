package com.niu.security.core.authentication.mobile;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * SmsCodeAuthenticationProvider
 *
 * @author [nza]
 * @version 1.0 2020/10/2
 * @createTime 2020/10/2
 */
public class SmsCodeAuthenticationProvider implements AuthenticationProvider {


    private UserDetailsService userDetailsService;

    SmsCodeAuthenticationProvider(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    /**
     * 校验逻辑
     *
     * @param authentication
     * @return
     * @throws AuthenticationException
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        SmsCodeAuthenticationToken token = (SmsCodeAuthenticationToken) authentication;
        UserDetails userDetails = userDetailsService.loadUserByUsername((String) token.getPrincipal());

        if (userDetails == null) {
            throw new InternalAuthenticationServiceException("无法获取用户信息");
        }

        SmsCodeAuthenticationToken res = new SmsCodeAuthenticationToken(userDetails, userDetails.getAuthorities());

        res.setDetails(token.getDetails());

        return res;
    }

    /**
     * 判断当前provider是否支持当前的登陆类型
     *
     * @param aClass
     * @return {@link boolean}
     */
    @Override
    public boolean supports(Class<?> aClass) {
        return SmsCodeAuthenticationToken.class.isAssignableFrom(aClass);
    }
}
