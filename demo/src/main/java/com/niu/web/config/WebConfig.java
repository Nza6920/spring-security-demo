package com.niu.web.config;

import com.niu.web.intercepter.TimeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/**
 * 描述
 *
 * @author [nza]
 * @version 1.0 2020/9/20
 * @createTime 2020/9/20
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private TimeInterceptor timeInterceptor;

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
    // 添加过滤器
//        registry.addInterceptor(timeInterceptor);
//        super.addInterceptors(registry);
//    }

//    @Bean
//    public FilterRegistrationBean timeFilter() {
//
//        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
//
//        TimeFilter timeFilter = new TimeFilter();
//        List<String> filterUrl = Lists.newArrayList();
//        filterUrl.add("/*");
//
//        registrationBean.setFilter(timeFilter);
//        registrationBean.setUrlPatterns(filterUrl);
//
//        return registrationBean;
//    }


    /**
     * 异步请求拦截器
     * @param configurer 配置对象
     */
    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {

        // 设置超时时间
        configurer.setDefaultTimeout(30000);

        // 设置线程池
//        configurer.setTaskExecutor();
    }
}
