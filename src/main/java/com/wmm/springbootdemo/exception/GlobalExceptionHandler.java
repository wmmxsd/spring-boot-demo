package com.wmm.springbootdemo.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.http.HttpStatus.*;

/**
 * @author wangmingming160328
 * @Description controller全局异常处理
 * @date @2020/5/7 18:53
 */
@ControllerAdvice("com.wmm.springbootdemo.controller")
@ResponseBody
public class GlobalExceptionHandler {
    private ErrorResponse illegalArgumentResponse = new ErrorResponse(new IllegalArgumentException("参数错误"));
    private ErrorResponse resourseNotFoundResponse = new ErrorResponse(new NullPointerException("sorry, the resourse not found!"));
    private ErrorResponse commonExceptionResponse = new ErrorResponse(new Exception("服务器出错啦"));

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> exceptionHandle(Exception e) {
        if (e instanceof IllegalArgumentException) {
            return ResponseEntity.status(BAD_REQUEST).body(illegalArgumentResponse);
        } else if (e instanceof NullPointerException) {
            return ResponseEntity.status(NOT_FOUND).body(resourseNotFoundResponse);
        }
        return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(commonExceptionResponse);
    }
}
