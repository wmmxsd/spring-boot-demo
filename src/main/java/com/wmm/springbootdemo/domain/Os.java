package com.wmm.springbootdemo.domain;

import lombok.Data;
import lombok.NonNull;

/**
 * @author wangmingming160328
 * @Description 操作系统实体类
 * @date @2020/5/12 17:05
 */
@Data
public class Os {
    @NonNull
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private String osType;
    private String description;
}
