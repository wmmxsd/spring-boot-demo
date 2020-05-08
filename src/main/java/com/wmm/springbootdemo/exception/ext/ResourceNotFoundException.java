package com.wmm.springbootdemo.exception.ext;

import com.wmm.springbootdemo.exception.BaseException;
import com.wmm.springbootdemo.exception.ErrorCode;

import java.util.Map;

/**
 * @author wangmingming160328
 * @Description 请求资源在服务器不存在异常（自定义异常）
 * @date @2020/5/8 11:35
 */
public class ResourceNotFoundException extends BaseException {

    public ResourceNotFoundException(Map<String, Object> data) {
        super(ErrorCode.RESOURCE_NOT_FOUND, data);
    }

    public ResourceNotFoundException(Throwable cause, Map<String, Object> data) {
        super(cause, ErrorCode.RESOURCE_NOT_FOUND, data);
    }
}
