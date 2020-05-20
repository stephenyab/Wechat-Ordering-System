package com.yang.restaurant.service.Impl;

import com.yang.restaurant.entity.AdminInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
class AdminServiceImplTest {

    @Autowired
    private AdminServiceImpl service;

    @Test
    void findAdminInfoByName() {
        AdminInfo adminInfo = service.findAdminInfoByName("aaa");
        log.info("admin:{}", adminInfo);
        Assert.assertNotEquals(null, adminInfo);
    }
}
