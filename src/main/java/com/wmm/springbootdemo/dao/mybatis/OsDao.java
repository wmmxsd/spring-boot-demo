package com.wmm.springbootdemo.dao.mybatis;

import com.wmm.springbootdemo.domain.Os;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wangmingming160328
 * @Description Os dao
 * @date @2020/5/12 17:07
 */
@Repository
@Mapper
public interface OsDao {
    /**
     * 通过名称查询系统
     * @param name 名称
     * @return 系统
     */
    List<Os> findByName(String name);
}
