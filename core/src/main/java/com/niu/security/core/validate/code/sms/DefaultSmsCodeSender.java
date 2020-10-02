package com.niu.security.core.validate.code.sms;

import lombok.extern.slf4j.Slf4j;

/**
 * 默认短信发送器
 *
 * @author [nza]
 * @version 1.0 2020/9/23
 * @createTime 2020/9/23
 */
@Slf4j
public class DefaultSmsCodeSender implements SmsCodeSender {
    @Override
    public void send(String mobile, String code) {
        log.info("发送短信验证码, mobile: {}, code: {}", mobile, code);
    }
}
