package com.niu.security.core.validate.code;


import org.springframework.security.core.AuthenticationException;

/**
 * 自定义验证码异常
 *
 * @author [nza]
 * @version 1.0 2020/9/21
 * @createTime 2020/9/21
 */
public class ValidateCodeException extends AuthenticationException {

    public ValidateCodeException(String msg) {
        super(msg);
    }
}
