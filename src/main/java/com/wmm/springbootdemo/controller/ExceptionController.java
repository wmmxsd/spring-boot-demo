package com.wmm.springbootdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangmingming160328
 * @Description 模拟抛出异常控制层
 * @date @2020/5/7 19:01
 */
@RestController
@RequestMapping("/api/v1")
public class ExceptionController {
    @GetMapping("/illegalArgumentException")
    public void throwException() {
        throw new IllegalArgumentException();
    }

    @GetMapping("/nullPointerException")
    public void throwException2() {
        throw new NullPointerException();
    }

    @GetMapping("/exception")
    public void throwException3() throws Exception {
        throw new Exception();
    }
}
