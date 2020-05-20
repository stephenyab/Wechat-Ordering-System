package com.yang.restaurant.service.Impl;

import com.yang.restaurant.entity.OrderDetail;
import com.yang.restaurant.repository.OrderDetailRepository;
import com.yang.restaurant.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName OrderDetailServiceImpl
 * @Description
 * @Author yang
 * @Date 2020/5/11 11:07
 * @Version 1.0
 */
@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailRepository repository;

    @Override
    public List<OrderDetail> findOrderDetailByOrderId(String orderId) {
        return repository.findByOrderId(orderId);
    }

    @Override
    public OrderDetail save(OrderDetail orderDetail) {
        return repository.save(orderDetail);
    }
}
