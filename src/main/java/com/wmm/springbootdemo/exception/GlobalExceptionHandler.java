package com.wmm.springbootdemo.exception;

import com.wmm.springbootdemo.exception.ext.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.http.HttpStatus.*;

/**
 * 全局异常处理
 * 通过{@link ControllerAdvice}和{@link ExceptionHandler}来处理异常
 * @author wangmingming160328
 * @Description controller全局异常处理
 * @date @2020/5/7 18:53
 */
@ControllerAdvice("com.wmm.springbootdemo.controller")
@ResponseBody
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException e, HttpServletRequest servletRequest) {
      return ResponseEntity.status(NOT_FOUND).body(new ErrorResponse(e, servletRequest.getRequestURI()));
    }
}
