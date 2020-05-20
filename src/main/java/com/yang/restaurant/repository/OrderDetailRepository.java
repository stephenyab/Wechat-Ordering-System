package com.yang.restaurant.repository;

import com.yang.restaurant.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @ClassName OrderDetailRepository
 * @Description 订单详情Jpa接口
 * @Author yang
 * @Date 2020/5/10 23:11
 * @Version 1.0
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {

    List<OrderDetail> findByOrderId(String orderId);
}
