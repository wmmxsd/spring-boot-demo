package com.wmm.springbootdemo.domain;

import lombok.Data;

/**
 * @author wangmingming160328
 * @Description 用户
 * @date @2020/5/7 17:26
 */
@Data
public class User {
    private int id;
    private String name;
    private int age;
    private double money;
}
