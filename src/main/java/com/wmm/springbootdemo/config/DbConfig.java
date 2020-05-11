package com.wmm.springbootdemo.config;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

/**
 * @author wangmingming160328
 * @Description 数据库配置读取类
 * @date @2020/5/11 10:16
 */
@Component
@Data
@NoArgsConstructor
public class DbConfig {
    @Value("${spring.datasource.url}")
    @NonNull
    private String url;
    @Value("${spring.datasource.username}")
    @NonNull
    private String userName;
    @Value("${spring.datasource.password}")
    @NonNull
    private String password;
}
