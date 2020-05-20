package com.yang.restaurant.repository;

import com.yang.restaurant.entity.OrderDiscuss;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName OrderDiscussRepository
 * @Description 评价Jpa接口
 * @Author yang
 * @Date 2020/5/10 23:12
 * @Version 1.0
 */
public interface OrderDiscussRepository extends JpaRepository<OrderDiscuss, String> {

    OrderDiscuss findByOrderId(String orderId);

    Page<OrderDiscuss> findByDiscussStatus(Integer discussStatus, Pageable pageable);
}
