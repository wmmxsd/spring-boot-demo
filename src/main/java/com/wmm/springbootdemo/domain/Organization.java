package com.wmm.springbootdemo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

/**
 * @author wangmingming160328
 * @Description 组织
 * @date @2020/5/11 14:50
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private Long id;

    @Column(nullable = false, unique = true)
    @NonNull
    private String name;
}
