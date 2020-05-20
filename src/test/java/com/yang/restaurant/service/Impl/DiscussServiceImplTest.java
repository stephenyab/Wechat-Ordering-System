package com.yang.restaurant.service.Impl;

import com.yang.restaurant.entity.OrderDiscuss;
import com.yang.restaurant.enums.DiscussStatusEnum;
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
class DiscussServiceImplTest {

    @Autowired
    private DiscussServiceImpl service;

    @Test
    void findAll() {
        PageRequest request = PageRequest.of(0, 5);
        Page<OrderDiscuss> orderDiscussPage = service.findAll(request);
        for (OrderDiscuss discuss : orderDiscussPage.getContent()) {
            log.info("discuss:{}", discuss);
        }
    }

    @Test
    void findDiscussByDiscussStatus() {
        PageRequest request = PageRequest.of(0, 5);
        Page<OrderDiscuss> orderDiscussPage = service.findDiscussByDiscussStatus(DiscussStatusEnum.GOOD.getCode(), request);
        for (OrderDiscuss discuss : orderDiscussPage.getContent()) {
            log.info("discuss:{}", discuss);
        }
    }

    @Test
    void findByOrderId() {
        OrderDiscuss discuss = service.findByOrderId("15882459111938367586");
        log.info("discuss:{}", discuss);
    }

    @Test
    void save() {
    }
}
