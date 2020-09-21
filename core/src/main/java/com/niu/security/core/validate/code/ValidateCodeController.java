package com.niu.security.core.validate.code;

import com.niu.security.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * 验证码控制器
 *
 * @author [nza]
 * @version 1.0 2020/9/21
 * @createTime 2020/9/21
 */
@RestController
public class ValidateCodeController {

    /**
     * session key
     */
    public static final String SESSION_KEY = "SESSION_KEY_IMAGE_CODE";

    /**
     * Spring session 工具
     */
    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    @Autowired
    private ValidateCodeGenerator imageCodeGenerator;

    /**
     * 获取图形验证码
     *
     * @param req  请求
     * @param resp 响应
     */
    @GetMapping("/code/image")
    public void createCode(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ImageCode imageCode = imageCodeGenerator.generate(new ServletWebRequest(req));
        sessionStrategy.setAttribute(new ServletWebRequest(req), SESSION_KEY, imageCode);

        ImageIO.write(imageCode.getImage(), "JPEG", resp.getOutputStream());
    }
}
