package com.yang.restaurant.service.Impl;

import com.yang.restaurant.entity.UserInfo;
import com.yang.restaurant.enums.UserIdentityEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
class UserServiceImplTest {

    @Autowired
    private UserServiceImpl service;

    @Test
    void findUserByUserIdentity() {
        PageRequest request = PageRequest.of(0, 5);
        Page<UserInfo> userInfoPage = service.findUserByUserIdentity(UserIdentityEnum.WAITER.getCode(), request);
        for (UserInfo userInfo : userInfoPage.getContent()) {
            log.info("userInfo:{}", userInfo);
        }
    }

    @Test
    void testFindUserByUserIdentity() {
        List<UserInfo> userInfoList = service.findUserByUserIdentity(UserIdentityEnum.WAITER.getCode());
        for (UserInfo userInfo : userInfoList) {
            log.info("userInfo:{}", userInfo);
        }
    }

    @Test
    void findUserByOpenid() {
        UserInfo userInfo = service.findUserByOpenid("1234dsa506");
        log.info("userInfo:{}", userInfo);
    }

    @Test
    void findUserByPhone() {
        UserInfo userInfo = service.findUserByPhone("15779346824");
        log.info("userInfo:{}", userInfo);
    }

    @Test
    void save() {
    }
}
