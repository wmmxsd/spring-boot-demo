package com.wmm.springbootdemo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

/**
 * 通过@Config
 * @author wangmingming160328
 * @Description 自定义配置类
 * @date @2020/5/11 11:31
 */
@Component
@ConfigurationProperties(prefix = "jdbc")
@PropertySource(value = "classpath:jdbc.properties")
@Data
@Validated
public class CustomConfig {
    @NotNull
    private String url;
    @NotNull
    private String username;
    @NotNull
    private String password;
}
