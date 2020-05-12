package com.wmm.springbootdemo.config;

import com.wmm.springbootdemo.interceptor.LogInterceptor;
import com.wmm.springbootdemo.interceptor.OldUrlInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author wangmingming160328
 * @Description 拦截器配置
 * @date @2020/5/12 10:30
 */
@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogInterceptor());
        registry.addInterceptor(new OldUrlInterceptor()).addPathPatterns("/admin/oldLogin");
    }
}
