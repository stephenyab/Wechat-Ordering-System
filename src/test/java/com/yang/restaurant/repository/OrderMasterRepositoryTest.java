package com.yang.restaurant.repository;

import com.yang.restaurant.entity.OrderMaster;
import com.yang.restaurant.enums.OrderStatusEnum;
import com.yang.restaurant.utils.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository repository;

    @Test
    void findAllByOrderStatusAndCreateTimeBetween() throws ParseException {
        DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        Date start = dateFormat1.parse(DateUtil.getMonthStart());
        Date end = dateFormat1.parse(DateUtil.getToday());
        List<OrderMaster> orderMasterList = repository.findAllByOrderStatusAndCreateTimeBetween(OrderStatusEnum.NEW.getCode(), start, end);

        for (OrderMaster orderMaster : orderMasterList) {
            log.info("orderMaster:{}", orderMaster);
        }
    }

    @Test
    void findAllByCreateTimeBetween() throws ParseException {
        DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        Date start = dateFormat1.parse(DateUtil.getMonthStart());
        Date end = dateFormat1.parse(DateUtil.getToday());
        List<OrderMaster> orderMasterList = repository.findAllByCreateTimeBetween(start, end);

        for (OrderMaster orderMaster : orderMasterList) {
            log.info("orderMaster:{}", orderMaster);
        }
    }

    @Test
    void findAllByCreateTimeIn() throws ParseException {
        DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        Date start = dateFormat1.parse("2020-05-16");
        Date end = dateFormat1.parse("2020-05-18");
        List<OrderMaster> orderMasterList = repository.findAllByCreateTimeBetween(start, end);

        for (OrderMaster orderMaster : orderMasterList) {
            log.info("orderMaster:{}", orderMaster);
        }
    }
}
