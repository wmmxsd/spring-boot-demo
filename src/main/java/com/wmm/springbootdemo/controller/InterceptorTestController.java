package com.wmm.springbootdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author wangmingming160328
 * @Description 拦截器demo控制层
 * @date @2020/5/12 10:41
 */
@RestController
@RequestMapping("/admin")
public class InterceptorTestController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping(value = {"/", "/test"})
    public ModelAndView test(ModelAndView modelAndView) {
        log.info("正在执行InterceptorTestController.test()方法");
        modelAndView.setViewName("test");
        modelAndView.addObject("hello", "world");
        return modelAndView;
    }

    @Deprecated
    @GetMapping(value = {"/oldLogin"})
    public String oldLogin(Model model) {
        return "oldLogin";
    }

    @GetMapping(value = {"/login"})
    public ModelAndView login() {
        log.info("正在执行InterceptorTestController.login()方法");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        modelAndView.addObject("hello", "world");
        return modelAndView;
    }
}
