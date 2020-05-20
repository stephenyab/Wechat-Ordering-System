package com.yang.restaurant.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @ClassName OrderDetail
 * @Description 订单详情实体类
 * @Author yang
 * @Date 2020/5/10 22:45
 * @Version 1.0
 */
@Data
@Entity
public class OrderDetail {

    @Id
    private String detailId;

    private String orderId;

    private String productId;

    private String productName;

    private BigDecimal productPrice;

    private Integer productQuantity;

    private String productIcon;
}
