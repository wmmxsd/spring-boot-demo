package com.wmm.springbootdemo.service;

import com.wmm.springbootdemo.SpringBootDemoApplication;
import com.wmm.springbootdemo.dao.mybatis.OsDao;
import com.wmm.springbootdemo.domain.Os;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class OsServiceTest {
    @Autowired
    private OsDao osDao;

    @Test
    void findByName() {
        List<Os> osList = osDao.findByName("windows");
        for (Os os : osList) {
            System.out.println(os);
        }

    }
}