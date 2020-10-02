package com.niu.security.core.validate.code.sms;

/**
 * 短信验证码发送
 *
 * @author [nza]
 * @version 1.0 2020/9/23
 * @createTime 2020/9/23
 */
public interface SmsCodeSender {

    void send(String mobile, String code);
}
