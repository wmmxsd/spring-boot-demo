package com.wmm.springbootdemo.service;

import com.wmm.springbootdemo.dao.mybatis.OsDao;
import com.wmm.springbootdemo.domain.Os;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wangmingming160328
 * @Description 操作系统service层
 * @date @2020/5/12 17:25
 */
@Service
public class OsService {
    @Autowired
    private OsDao osDao;

    public List<Os> findByName(String name) {
        return osDao.findByName(name);
    }
}
