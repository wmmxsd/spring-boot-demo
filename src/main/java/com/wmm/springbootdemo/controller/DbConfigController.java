package com.wmm.springbootdemo.controller;

import com.wmm.springbootdemo.config.CustomConfig;
import com.wmm.springbootdemo.config.DbConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @author wangmingming160328
 * @Description 数据库配置控制层
 * @date @2020/5/11 10:28
 */
@RestController
@RequestMapping("/api")
public class DbConfigController {
    @Autowired
    @Qualifier("dbConfig")
    private DbConfig dbConfig;

    @Resource
    private CustomConfig customConfig;
    /**
     * 返回dbConfig对象
     * @return dbConfig对象
     */
    @GetMapping("/v1/dbconfig")
    public DbConfig getDbConfig() {
//        return ResponseEntity.ok(dbConfig);
        return dbConfig;
    }

    /**
     * 返回dbConfig的字符串
     * @return dbConfig的字符串
     */
    @GetMapping("/v2/dbconfig")
    public ResponseEntity<String> getDbConfigure() {
//        return ResponseEntity.ok(dbConfig.toString());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Custom-Header", "helloWorld");
        return new ResponseEntity<>(dbConfig.toString(), httpHeaders, HttpStatus.OK);
    }

    @GetMapping("/v3/dbconfig")
    public ResponseEntity<CustomConfig> getDbConfigByPropertySourceAnnotation() {
        return ResponseEntity.status(HttpStatus.OK).body(customConfig);
    }
}
