package com.niu.security.core.validate.code;

import com.niu.security.core.validate.code.image.ImageCode;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * 校验码生成器
 *
 * @author [nza]
 * @version 1.0 2020/9/21
 * @createTime 2020/9/21
 */
public interface ValidateCodeGenerator {

    /**
     * 验证码生成
     * @param req 请求
     * @return {@link ImageCode}
     */
    ValidateCode generate(ServletWebRequest req);
}
