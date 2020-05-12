package com.wmm.springbootdemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

/**
 * @author wangmingming160328
 * @Description 过滤器配置
 * @date @2020/5/11 16:49
 */
@Configuration
public class FilterConfig {
    @Autowired
    @Qualifier("filterOne")
    private Filter filterOne;

    @Autowired
    @Qualifier("filterTwo")
    private Filter filterTwo;

   /* @Bean
    public FilterRegistrationBean<Filter> setFilterOne() {
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setName("过滤器1");
        filterRegistrationBean.setFilter(filterOne);
        filterRegistrationBean.setOrder(1);
        return filterRegistrationBean;
    }*/

    /*@Bean
    public FilterRegistrationBean<Filter> setFilterTwo() {
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setName("过滤器2");
        filterRegistrationBean.setFilter(filterTwo);
        filterRegistrationBean.setOrder(2);
        return filterRegistrationBean;
    }*/
}
