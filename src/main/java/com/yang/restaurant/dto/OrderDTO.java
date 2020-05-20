package com.yang.restaurant.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.yang.restaurant.entity.OrderDetail;
import com.yang.restaurant.enums.OrderStatusEnum;
import com.yang.restaurant.enums.PayStatusEnum;
import com.yang.restaurant.utils.EnumUtil;
import com.yang.restaurant.utils.serializer.Date2LongSerializer;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @ClassName OrderDTO
 * @Description
 * @Author yang
 * @Date 2020/5/10 23:38
 * @Version 1.0
 */
@Data
public class OrderDTO {

    private String orderId;

    private String buyerName;

    private String buyerPhone;

    private String buyerAddress;

    private String buyerOpenid;

    private String chiefOpenid;

    private String waiterOpenid;

    private BigDecimal orderAmount;

    private Integer orderStatus;

    private Integer payStatus;

    private Integer discussStatus;

    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;

    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

    /**
     * 详细订单信息
     */
    private List<OrderDetail> orderDetailList;

    public OrderStatusEnum getOrderStatusEnum() {
        return EnumUtil.getByCode(orderStatus, OrderStatusEnum.class);
    }

    public PayStatusEnum getPayStatusEnum() {
        return EnumUtil.getByCode(payStatus, PayStatusEnum.class);
    }
}

