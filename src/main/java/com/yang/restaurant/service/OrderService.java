package com.yang.restaurant.service;

import com.yang.restaurant.dto.OrderDTO;
import com.yang.restaurant.entity.OrderDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

/**
 * @ClassName OrderService
 * @Description
 * @Author yang
 * @Date 2020/5/10 23:32
 * @Version 1.0
 */
public interface OrderService {

    //创建订单
    OrderDTO create(OrderDTO orderDTO);

    //查询单个列表
    OrderDTO findOne(String orderId);

    //查询订单列表
    Page<OrderDTO> findList(String buyerOpenId, Pageable pageable);

    //查询所有订单
    List<OrderDTO> findAll(String buyerOpenid);

    //查询当日所有订单
    List<OrderDTO> findAllThisDay(Date start, Date end);

    //查询当日完结订单
    List<OrderDTO> findAllFinishThisDay(Date start, Date end);

    //查询本月所有订单
    List<OrderDTO> findAllThisMonth(Date start, Date end);

    //查询本月完结订单
    List<OrderDTO> findAllFinishThisMonth(Date start, Date end);

    //通过订单状态和支付状态查询订单列表
    List<OrderDTO> findAllByOrderStatusAndPayStatus(Integer orderStatus, Integer payStatus);

    //查找正在烹饪的订单
    List<OrderDTO> findAllByChiefOpenidAndOrderStatus(String chiefOpenid, Integer orderStatus);

    //查找正在上菜中的订单
    List<OrderDTO> findAllByWaiterOpenidAndOrderStatus(String waiterOpenid, Integer orderStatus);

    //取消订单
    OrderDTO cancel(OrderDTO orderDTO);

    //完结订单
    OrderDTO finish(OrderDTO orderDTO);

    OrderDTO adminFinish(OrderDTO orderDTO);

    //支付订单
    OrderDTO paid(OrderDTO orderDTO);

    //根据订单进行烹饪
    OrderDTO cooking(String chiefOpenid, OrderDTO orderDTO);

    //完成订单菜品的烹饪
    OrderDTO finishCook(OrderDTO orderDTO);

    //上菜
    OrderDTO sending(String waiterOpenid, OrderDTO orderDTO);

    //订单列表
    Page<OrderDTO> findList(Pageable pageable);

    //改变订单是否评论状态
    void changeDiscussStatus(String orderId);
}
