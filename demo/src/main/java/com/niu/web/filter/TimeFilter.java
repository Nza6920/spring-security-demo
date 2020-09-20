package com.niu.web.filter;


import javax.servlet.*;
import java.io.IOException;

/**
 * 描述
 *
 * @author [nza]
 * @version 1.0 2020/9/20
 * @createTime 2020/9/20
 */
public class TimeFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("filter init");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filter doFilter start");

        long start = System.currentTimeMillis();
        filterChain.doFilter(req, res);
        long end = System.currentTimeMillis();

        System.out.println("耗时: " + (end - start));
    }

    @Override
    public void destroy() {
        System.out.println("filter destroy");

    }
}
