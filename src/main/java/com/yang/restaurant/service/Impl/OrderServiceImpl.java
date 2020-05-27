package com.yang.restaurant.service.Impl;

import com.yang.restaurant.converter.OrderMaster2OrderDTOConverter;
import com.yang.restaurant.dto.OrderDTO;
import com.yang.restaurant.dto.RestInfoDTO;
import com.yang.restaurant.entity.OrderDetail;
import com.yang.restaurant.entity.OrderMaster;
import com.yang.restaurant.entity.ProductInfo;
import com.yang.restaurant.enums.OrderStatusEnum;
import com.yang.restaurant.enums.PayStatusEnum;
import com.yang.restaurant.enums.ResultEnum;
import com.yang.restaurant.exception.CommonException;
import com.yang.restaurant.repository.OrderMasterRepository;
import com.yang.restaurant.service.*;
import com.yang.restaurant.utils.DateUtil;
import com.yang.restaurant.utils.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.ConnectException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * @ClassName OrderServiceImpl
 * @Description
 * @Author yang
 * @Date 2020/5/10 23:24
 * @Version 1.0
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Autowired
    private RestInfoService restInfoService;

    @Autowired
    private PushMessageService pushMessageService;

    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        String orderId = KeyUtil.getUniqueKey();
        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);

        //查询订单中具体商品
        for (OrderDetail orderDetail : orderDTO.getOrderDetailList()) {
            ProductInfo productInfo;
            try {
                productInfo = productService.findOne(orderDetail.getProductId());
            } catch (CommonException e) {
                throw e;
            }

            //计算订单总价
            orderAmount = productInfo.getProductPrice()
                    .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                    .add(orderAmount);
            BeanUtils.copyProperties(productInfo, orderDetail);
            orderDetail.setDetailId(KeyUtil.getUniqueKey());
            orderDetail.setOrderId(orderId);
            orderDetailService.save(orderDetail);
        }

        //订单入库
        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderId(orderId);
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderAmount(orderAmount);
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMaster.setDiscussStatus(0);
        orderMasterRepository.save(orderMaster);

        orderDTO.setOrderAmount(orderAmount);

        return orderDTO;
    }

    @Override
    public OrderDTO findOne(String orderId) {
        OrderMaster orderMaster;

        try {
            orderMaster = orderMasterRepository.findById(orderId).get();
        } catch (NoSuchElementException e) {
            throw new CommonException(ResultEnum.ORDER_NOT_EXIST);
        }

        List<OrderDetail> orderDetailList = orderDetailService.findOrderDetailByOrderId(orderId);
        if (CollectionUtils.isEmpty(orderDetailList)) {
            throw new CommonException(ResultEnum.ORDER_DETAIL_NOT_EXIST);
        }

        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster, orderDTO);
        orderDTO.setOrderDetailList(orderDetailList);

        return orderDTO;
    }

    @Override
    public Page<OrderDTO> findList(String buyerOpenId, Pageable pageable) {
        Page<OrderMaster> orderMasterPage = orderMasterRepository.findByBuyerOpenid(buyerOpenId, pageable);
        List<OrderDTO> orderDTOList = OrderMaster2OrderDTOConverter.convert(orderMasterPage.getContent());

        return new PageImpl<>(orderDTOList, pageable, orderMasterPage.getTotalElements());
    }

    @Override
    public List<OrderDTO> findAll(String buyerOpenid) {
        List<OrderMaster> orderMasterList = orderMasterRepository.findByBuyerOpenid(buyerOpenid);
        List<OrderDTO> orderDTOList = OrderMaster2OrderDTOConverter.convert(orderMasterList);

        return orderDTOList;
    }

    @Override
    public List<OrderDTO> findAllThisDay(Date start, Date end) {
        List<OrderMaster> orderMasterList = orderMasterRepository.findAllByCreateTimeBetween(start, end);
        List<OrderDTO> orderDTOList = OrderMaster2OrderDTOConverter.convert(orderMasterList);

        return orderDTOList;
    }

    @Override
    public List<OrderDTO> findAllFinishThisDay(Date start, Date end) {
        List<OrderMaster> orderMasterList = orderMasterRepository.findAllByOrderStatusAndCreateTimeBetween(OrderStatusEnum.FINISH.getCode(), start, end);
        List<OrderDTO> orderDTOList = OrderMaster2OrderDTOConverter.convert(orderMasterList);

        return orderDTOList;
    }

    @Override
    public List<OrderDTO> findAllThisMonth(Date start, Date end) {
        List<OrderMaster> orderMasterList = orderMasterRepository.findAllByCreateTimeBetween(start, end);
        List<OrderDTO> orderDTOList = OrderMaster2OrderDTOConverter.convert(orderMasterList);

        return orderDTOList;
    }

    @Override
    public List<OrderDTO> findAllFinishThisMonth(Date start, Date end) {
        List<OrderMaster> orderMasterList = orderMasterRepository.findAllByOrderStatusAndCreateTimeBetween(OrderStatusEnum.FINISH.getCode(), start, end);
        List<OrderDTO> orderDTOList = OrderMaster2OrderDTOConverter.convert(orderMasterList);

        return orderDTOList;
    }

    @Override
    public List<OrderDTO> findAllByOrderStatusAndPayStatus(Integer orderStatus, Integer payStatus) {
        List<OrderMaster> orderMasterList = orderMasterRepository.findByOrderStatusAndPayStatus(orderStatus, payStatus);
        List<OrderDTO> orderDTOList = OrderMaster2OrderDTOConverter.convert(orderMasterList);

        return orderDTOList;
    }

    @Override
    public List<OrderDTO> findAllByChiefOpenidAndOrderStatus(String chiefOpenid, Integer orderStatus) {
        List<OrderMaster> orderMasterList = orderMasterRepository.findByChiefOpenidAndOrderStatus(chiefOpenid, orderStatus);
        List<OrderDTO> orderDTOList = OrderMaster2OrderDTOConverter.convert(orderMasterList);

        return orderDTOList;
    }

    @Override
    public List<OrderDTO> findAllByWaiterOpenidAndOrderStatus(String waiterOpenid, Integer orderStatus) {
        List<OrderMaster> orderMasterList = orderMasterRepository.findByWaiterOpenidAndOrderStatus(waiterOpenid, orderStatus);
        List<OrderDTO> orderDTOList = OrderMaster2OrderDTOConverter.convert(orderMasterList);

        return orderDTOList;
    }

    @Override
    public OrderDTO cancel(OrderDTO orderDTO) {
        OrderMaster orderMaster = new OrderMaster();

        //判断订单状态
        if (!orderDTO.getOrderStatus().equals(OrderStatusEnum.NEW.getCode())) {
            log.error("【取消订单】订单状态不正确，orderId={}，orderStatus={}", orderDTO.getOrderId(), orderDTO.getOrderStatus());
            throw new CommonException(ResultEnum.ORDER_STATUS_ERROR);
        }

        orderDTO.setOrderStatus(OrderStatusEnum.CANCEL.getCode());

        //如果已经支付，退款
        if (orderDTO.getPayStatus().equals(PayStatusEnum.SUCCESS.getCode())) {
            orderDTO.setPayStatus(PayStatusEnum.REFUND_SUCCESSFUL.getCode());
        }

        BeanUtils.copyProperties(orderDTO, orderMaster);
        OrderMaster updateResult = orderMasterRepository.save(orderMaster);

        if (updateResult == null) {
            log.error("【取消订单】更新失败，orderMaster={}", orderMaster);
            throw new CommonException(ResultEnum.ORDER_UPDATE_FAIL);
        }

        return orderDTO;
    }

    @Override
    public OrderDTO finish(OrderDTO orderDTO) {
        //判断订单状态
        if (!orderDTO.getOrderStatus().equals(OrderStatusEnum.SENDING.getCode())) {
            log.error("【完结订单】订单状态不正确，orderID={}，orderStatus={}", orderDTO.getOrderId(), orderDTO.getOrderStatus());
            throw new CommonException(ResultEnum.ORDER_STATUS_ERROR);
        }

        //修改订单状态
        orderDTO.setOrderStatus(OrderStatusEnum.FINISH.getCode());
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDTO, orderMaster);
        OrderMaster updateResult = orderMasterRepository.save(orderMaster);

        if (updateResult == null) {
            log.error("【完结订单】更新失败，orderMaster={}", orderMaster);
            throw new CommonException(ResultEnum.ORDER_UPDATE_FAIL);
        }

        //订单完结，模板消息推送
        RestInfoDTO restInfoDTO = restInfoService.findRestInfo();
        pushMessageService.orderStatus(orderDTO, restInfoDTO);

        return orderDTO;
    }

    @Override
    public OrderDTO adminFinish(OrderDTO orderDTO) {
        //判断订单状态
        if (orderDTO.getOrderStatus().equals(OrderStatusEnum.CANCEL.getCode()) ||
                orderDTO.getOrderStatus().equals(OrderStatusEnum.FINISH.getCode())) {
            if (!orderDTO.getPayStatus().equals(PayStatusEnum.SUCCESS)) {
                log.error("【完结订单】订单状态不正确，orderID={}，orderStatus={}", orderDTO.getOrderId(), orderDTO.getOrderStatus());
                throw new CommonException(ResultEnum.ORDER_STATUS_ERROR);
            }
        }

        //修改订单状态
        orderDTO.setOrderStatus(OrderStatusEnum.FINISH.getCode());
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDTO, orderMaster);
        OrderMaster updateResult = orderMasterRepository.save(orderMaster);

        if (updateResult == null) {
            log.error("【完结订单】更新失败，orderMaster={}", orderMaster);
            throw new CommonException(ResultEnum.ORDER_UPDATE_FAIL);
        }

        //订单完结，模板消息推送
        RestInfoDTO restInfoDTO = restInfoService.findRestInfo();
        pushMessageService.orderStatus(orderDTO, restInfoDTO);

        return orderDTO;
    }

    @Override
    public OrderDTO paid(OrderDTO orderDTO) {
        //判断订单状态
        if (!orderDTO.getOrderStatus().equals(OrderStatusEnum.NEW.getCode())) {
            log.error("【支付订单】订单状态不正确，orderID={}，orderStatus={}", orderDTO.getOrderId(), orderDTO.getOrderStatus());
            throw new CommonException(ResultEnum.ORDER_STATUS_ERROR);
        }

        //判断支付状态
        if (!orderDTO.getPayStatus().equals(PayStatusEnum.WAIT.getCode())) {
            log.error("【支付订单】订单支付状态不正确，orderDRO={}", orderDTO);
            throw new CommonException(ResultEnum.ORDER_PAY_STATUS_ERROR);
        }

        //更新订单支付状态
        orderDTO.setPayStatus(PayStatusEnum.SUCCESS.getCode());
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDTO, orderMaster);
        OrderMaster updateResult = orderMasterRepository.save(orderMaster);

        if (updateResult == null) {
            log.error("【支付订单】更新失败，orderMaster={}", orderMaster);
            throw new CommonException(ResultEnum.ORDER_UPDATE_FAIL);
        }

        return orderDTO;
    }

    @Override
    public OrderDTO cooking(String chiefOpenid, OrderDTO orderDTO) {
        //判断订单状态
        if (!orderDTO.getOrderStatus().equals(OrderStatusEnum.NEW.getCode())) {
            throw new CommonException(ResultEnum.ORDER_STATUS_ERROR);
        }

        //修改订单状态
        orderDTO.setOrderStatus(OrderStatusEnum.COOKING.getCode());
        orderDTO.setChiefOpenid(chiefOpenid);
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDTO, orderMaster);
        OrderMaster updateResult = orderMasterRepository.save(orderMaster);

        if (updateResult == null) {
            log.error("【烹饪】更新失败，orderMaster={}", orderMaster);
            throw new CommonException(ResultEnum.ORDER_UPDATE_FAIL);
        }

        return orderDTO;
    }

    @Override
    public OrderDTO finishCook(OrderDTO orderDTO) {
        //判断订单状态
        if (!orderDTO.getOrderStatus().equals(OrderStatusEnum.COOKING.getCode())) {
            throw new CommonException(ResultEnum.ORDER_STATUS_ERROR);
        }

        //修改订单状态
        orderDTO.setOrderStatus(OrderStatusEnum.COOKED.getCode());
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDTO, orderMaster);
        OrderMaster updateResult = orderMasterRepository.save(orderMaster);

        if (updateResult == null) {
            log.error("【烹饪】更新失败，orderMaster={}", orderMaster);
            throw new CommonException(ResultEnum.ORDER_UPDATE_FAIL);
        }

        return orderDTO;
    }

    @Override
    public OrderDTO sending(String waiterOpenid, OrderDTO orderDTO) {
        //判断订单状态
        if (!orderDTO.getOrderStatus().equals(OrderStatusEnum.COOKED.getCode())) {
            throw new CommonException(ResultEnum.ORDER_STATUS_ERROR);
        }

        //修改订单状态
        orderDTO.setOrderStatus(OrderStatusEnum.SENDING.getCode());
        orderDTO.setWaiterOpenid(waiterOpenid);
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDTO, orderMaster);
        OrderMaster updateResult = orderMasterRepository.save(orderMaster);

        if (updateResult == null) {
            log.error("【送餐】更新失败，orderMaster={}", orderMaster);
            throw new CommonException(ResultEnum.ORDER_UPDATE_FAIL);
        }

        return orderDTO;
    }

    @Override
    public Page<OrderDTO> findList(Pageable pageable) {
        Page<OrderMaster> orderMasterPage = orderMasterRepository.findAll(pageable);
        List<OrderDTO> orderDTOList = OrderMaster2OrderDTOConverter.convert(orderMasterPage.getContent());

        return new PageImpl<>(orderDTOList, pageable, orderMasterPage.getTotalElements());
    }

    @Override
    public void changeDiscussStatus(String orderId) {
        OrderMaster orderMaster;

        try {
            orderMaster = orderMasterRepository.findById(orderId).get();
        } catch (NoSuchElementException e) {
            throw new CommonException(ResultEnum.ORDER_NOT_EXIST);
        }

        orderMaster.setDiscussStatus(1);
        orderMasterRepository.save(orderMaster);
    }
}
