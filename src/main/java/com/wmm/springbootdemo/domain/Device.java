package com.wmm.springbootdemo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

/**
 * @author wangmingming160328
 * @Description 设备实体类
 * @date @2020/5/9 15:22
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
//@Table(name = "device")
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = false, nullable = false)
    @NonNull
    private String ip;
    private String ipNumber;
    @Column(unique = false, nullable = true)
    private String mac;
    private String name;
}
