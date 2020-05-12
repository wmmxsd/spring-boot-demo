package com.wmm.springbootdemo.dao.jpa;

import com.wmm.springbootdemo.domain.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wangmingming160328
 * @Description 组织机构dao层
 * @date @2020/5/11 15:03
 */
@Repository
public interface OrganizationRepository<T extends Organization, Long> extends JpaRepository<T, Long> {
}
