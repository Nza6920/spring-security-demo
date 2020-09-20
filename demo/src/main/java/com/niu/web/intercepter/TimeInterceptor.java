package com.niu.web.intercepter;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义拦截器
 *
 * @author [nza]
 * @version 1.0 2020/9/20
 * @createTime 2020/9/20
 */
@Component
public class TimeInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handle) throws Exception {
        System.out.println("preHandle");
        req.setAttribute("startTime", System.currentTimeMillis());
        System.out.println(((HandlerMethod) handle).getMethod().getName());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest req, HttpServletResponse res, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");

        long start = (long) req.getAttribute("startTime");
        System.out.println(System.currentTimeMillis() - start);
    }

    @Override
    public void afterCompletion(HttpServletRequest req, HttpServletResponse res, Object o, Exception e) throws Exception {
        System.out.println("afterCompletion");
    }
}
