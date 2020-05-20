package com.yang.restaurant.service.Impl;

import com.yang.restaurant.entity.OrderDetail;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
class OrderDetailServiceImplTest {

    @Autowired
    private OrderDetailServiceImpl service;

    @Test
    void findOrderDetailByOrderId() {
        List<OrderDetail> orderDetailList = service.findOrderDetailByOrderId("15882450911938367586");
        for (OrderDetail orderDetail : orderDetailList) {
            log.info("orderDetail:{}", orderDetail);
        }
    }
}
