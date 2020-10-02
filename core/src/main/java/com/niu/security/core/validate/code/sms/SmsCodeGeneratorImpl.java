package com.niu.security.core.validate.code.sms;

import com.niu.security.core.properties.SecurityProperties;
import com.niu.security.core.validate.code.ValidateCode;
import com.niu.security.core.validate.code.ValidateCodeGenerator;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * 短信验证码生成器
 *
 * @author [nza]
 * @version 1.0 2020/9/21
 * @createTime 2020/9/21
 */
@Component("smsCodeGenerator")
public class SmsCodeGeneratorImpl implements ValidateCodeGenerator {

    public SmsCodeGeneratorImpl(SecurityProperties securityProperties) {
        this.securityProperties = securityProperties;
    }

    private SecurityProperties securityProperties;


    @Override
    public ValidateCode generate(ServletWebRequest req) {
        String code = RandomStringUtils.randomNumeric(securityProperties.getCode().getSms().getLength());
        return new ValidateCode(code, securityProperties.getCode().getSms().getExpireIn());
    }
}
