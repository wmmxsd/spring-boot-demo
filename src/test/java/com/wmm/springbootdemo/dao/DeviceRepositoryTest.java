package com.wmm.springbootdemo.dao;

import com.wmm.springbootdemo.domain.Device;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class DeviceRepositoryTest {
    @Autowired
    DeviceRepository deviceRepository;

    @Test
    void save() {
        deviceRepository.save(new Device(123L, "1.1.1.1", "2234", "21-11-11-11-11-11", "王明明1"));
        Device device = new Device(123L, "1.1.1.2", "1234", "11-11-11-11-11-11", "王明明");
        Device newDevice = deviceRepository.save(device);
        Assert.notNull(newDevice, "");
        List<Device> deviceList = deviceRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
        for (Device dev : deviceList) {
            System.out.println(dev.toString());
        }
        deviceList = deviceRepository.findByIp("1.1.1.1");
        Assert.isTrue("1.1.1.1".equals(deviceList.get(0).getIp()), "");
        deviceList = deviceRepository.findByName("王明明");
        Assert.isTrue("王明明".equals(deviceList.get(0).getName()), "");
        deviceRepository.updateNameById(2L, "test");
        Optional<Device> optionalDevice = deviceRepository.findById(2L);
        Assert.isTrue("test".equals(optionalDevice.get().getName()), "");
        deviceList = deviceRepository.findByIpAndMac("1.1.1.2", "21-11-11-11-11-11");
        for (Device dev : deviceList) {
            System.out.println(dev.toString());
        }
    }
}