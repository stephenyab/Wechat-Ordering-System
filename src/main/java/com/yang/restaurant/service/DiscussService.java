package com.yang.restaurant.service;

import com.yang.restaurant.entity.OrderDiscuss;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @ClassName DiscussService
 * @Description
 * @Author yang
 * @Date 2020/5/10 23:28
 * @Version 1.0
 */
public interface DiscussService {

    Page<OrderDiscuss> findAll(Pageable pageable);

    Page<OrderDiscuss> findDiscussByDiscussStatus(Integer discussStatus, Pageable pageable);

    OrderDiscuss findByOrderId(String orderId);

    OrderDiscuss save(OrderDiscuss orderDiscuss);
}
