package com.wmm.springbootdemo.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @author wangmingming160328
 * @Description 异常包装类
 * @date @2020/5/7 18:49
 */
public class ErrorResponse {
    @Getter
    @Setter
    private String message;
    @Getter
    @Setter
    private String errorTypeName;

    public ErrorResponse(Exception e) {
        this(e.getClass().getName(), e.getMessage());
    }

    public ErrorResponse(String errorTypeName, String message) {
        this.errorTypeName = errorTypeName;
        this.message = message;
    }
}
