package com.yang.restaurant.service;

import com.yang.restaurant.entity.OrderDetail;

import java.util.List;

/**
 * @ClassName OrderDetailService
 * @Description
 * @Author yang
 * @Date 2020/5/10 23:24
 * @Version 1.0
 */
public interface OrderDetailService {

    List<OrderDetail> findOrderDetailByOrderId(String orderId);

    OrderDetail save(OrderDetail orderDetail);
}
