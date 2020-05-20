package com.yang.restaurant.service.Impl;

import com.yang.restaurant.entity.OrderDiscuss;
import com.yang.restaurant.repository.OrderDiscussRepository;
import com.yang.restaurant.service.DiscussService;
import com.yang.restaurant.utils.KeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @ClassName DiscussServiceImpl
 * @Description
 * @Author yang
 * @Date 2020/5/10 23:30
 * @Version 1.0
 */
@Service
public class DiscussServiceImpl implements DiscussService {

    @Autowired
    private OrderDiscussRepository repository;

    @Override
    public Page<OrderDiscuss> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Page<OrderDiscuss> findDiscussByDiscussStatus(Integer discussStatus, Pageable pageable) {
        return repository.findByDiscussStatus(discussStatus, pageable);
    }

    @Override
    public OrderDiscuss findByOrderId(String orderId) {
        return repository.findByOrderId(orderId);
    }

    @Override
    public OrderDiscuss save(OrderDiscuss orderDiscuss) {
        orderDiscuss.setDiscussId(KeyUtil.getDiscussUniqueKey());
        return repository.save(orderDiscuss);
    }
}
