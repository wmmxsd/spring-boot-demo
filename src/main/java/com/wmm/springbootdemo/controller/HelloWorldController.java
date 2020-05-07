package com.wmm.springbootdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangmingming160328
 * @Description 你好，世界
 * @date @2020/5/7 14:44
 */
@RestController
@RequestMapping("test")
public class HelloWorldController {
    @GetMapping(name = "1", value = "hello")
    public String sayHello() {
        return "Hello World";
    }
}
