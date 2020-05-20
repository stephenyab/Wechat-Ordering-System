package com.yang.restaurant.repository;

import com.yang.restaurant.entity.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

/**
 * @ClassName OrderMasterRepository
 * @Description 订单Jpa接口
 * @Author yang
 * @Date 2020/5/10 23:13
 * @Version 1.0
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {

    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);

    List<OrderMaster> findByBuyerOpenid(String buyerOpenid);

    List<OrderMaster> findByOrderStatusAndPayStatus(Integer orderStatus, Integer payStatus);

    List<OrderMaster> findByChiefOpenidAndOrderStatus(String chiefOpenid, Integer orderStatus);

    List<OrderMaster> findByWaiterOpenidAndOrderStatus(String waiterOpenid, Integer orderStatus);

    List<OrderMaster> findAllByOrderStatusAndCreateTimeBetween(Integer orderStatus, Date start, Date end);

    List<OrderMaster> findAllByCreateTimeBetween(Date start, Date end);
}
