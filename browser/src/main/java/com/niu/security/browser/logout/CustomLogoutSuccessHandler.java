package com.niu.security.browser.logout;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.niu.security.browser.support.SimpleResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 退出登陆成功处理器
 *
 * @author [nza]
 * @version 1.0 2020/10/4
 * @createTime 2020/10/4
 */
@Slf4j
public class CustomLogoutSuccessHandler implements LogoutSuccessHandler {

    public CustomLogoutSuccessHandler(String sigoutUrl) {
        this.sigoutUrl = sigoutUrl;
    }

    private String sigoutUrl;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        log.info("退出成功");

        if (StringUtils.isNotEmpty(sigoutUrl)) {
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(objectMapper.writeValueAsString(new SimpleResponse("退出成功")));
        } else {
            response.sendRedirect(sigoutUrl);
        }
    }
}
