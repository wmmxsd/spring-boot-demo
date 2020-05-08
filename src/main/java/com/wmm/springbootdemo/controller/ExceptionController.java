package com.wmm.springbootdemo.controller;

import com.wmm.springbootdemo.exception.ErrorCode;
import com.wmm.springbootdemo.exception.ext.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;

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

    /**
     * 通过抛出ResponseStatusException异常来处理异常
     */
    @GetMapping("/responseStatusException")
    public void throwResponseStatusException() {
        throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, "Bad Gateway", new StackOverflowError());
    }

    @GetMapping("/resourceNotFoundException")
    public void throwResourceNotFoundException() {
        Map<String, Object> map = new HashMap<>(1);
        map.put("id", "1234");
        throw new ResourceNotFoundException(map);
    }
}
