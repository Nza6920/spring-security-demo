package com.niu.security.app;

import com.niu.security.core.social.CustomSpringSocialConfigurer;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * 监听 Spring Bean 周期
 *
 * @author [nza]
 * @version 1.0 2020/10/6
 * @createTime 2020/10/6
 */
@Component
public class SpringSocialConfigurerPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        // App 环境下替换注册地址
        if (StringUtils.equals(beanName, "customSocialSecurityConfig")) {
            CustomSpringSocialConfigurer customSpringSocialConfigurer = (CustomSpringSocialConfigurer) bean;
            customSpringSocialConfigurer.signupUrl("/social/signUp");
            return customSpringSocialConfigurer;
        }
        return bean;
    }
}
