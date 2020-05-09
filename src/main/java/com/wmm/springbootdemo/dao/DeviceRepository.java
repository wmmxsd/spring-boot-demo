package com.wmm.springbootdemo.dao;

import com.wmm.springbootdemo.domain.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

/**
 * @author wangmingming160328
 * @Description Jpa接口
 * @date @2020/5/9 16:55
 */
@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {
    /**
     * 根据name查询设备集合
     * @param name 名称
     * @return 设备集合
     */
    List<Device> findByName(String name);

    /**
     * 根据ip查询设备集合
     * @param ip 名称
     * @return 设备集合
     */
    List<Device> findByIp(String ip);

    /**
     * 更新指定id的设备的名称
     * @param id 设备id
     * @param name 设备名
     */
    @Modifying
    @Transactional
    @Query("UPDATE Device SET name = ?2 where id = ?1")
    void updateNameById(@NotNull long id, @NotNull String name);

    /**
     * 根据ip和name查询设备
     * @param ip ip
     * @param name name
     * @return 设备集合
     */
    @Query(value = "SELECT * FROM Device WHERE ip = :ip AND name = :name", nativeQuery = true)
    List<Device> findByIpAndMac(@Param("ip") String ip, @Param("name") String name);
}
