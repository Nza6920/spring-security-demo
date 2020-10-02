package com.niu.security.core.validate.code;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 验证码控制器
 *
 * @author [nza]
 * @version 1.0 2020/9/21
 * @createTime 2020/9/21
 */
@RestController
@Slf4j
public class ValidateCodeController {

    @Autowired
    private Map<String, ValidateCodeProcessor> validateCodeProcessors;

    /**
     * 创建验证码, 根据验证码类型不同, 调用不同的{@link ValidateCodeProcessor }接口实现
     *
     * @param req
     * @param resp
     */
    @GetMapping("/code/{type}")
    public void createCode(HttpServletRequest req, HttpServletResponse resp, @PathVariable String type) throws Exception {
        validateCodeProcessors.get(type + "ValidateCodeProcessor").create(new ServletWebRequest(req, resp));
    }
}
