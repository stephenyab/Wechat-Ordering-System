package com.yang.restaurant.entity;

import com.yang.restaurant.enums.OrderStatusEnum;
import com.yang.restaurant.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName OrderMaster
 * @Description 订单实体类
 * @Author yang
 * @Date 2020/5/10 22:47
 * @Version 1.0
 */
@Data
@Entity
@DynamicUpdate
public class OrderMaster {

    @Id
    private String orderId;

    private String buyerName;

    private String buyerPhone;

    private String buyerAddress;

    private String buyerOpenid;

    private String chiefOpenid;

    private String waiterOpenid;

    private BigDecimal orderAmount;

    /**
     * @Description 0为未评价，1为已评价
     * @Date 2020/4/4 19:08
     **/
    private Integer discussStatus = 0;

    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    private Date createTime;

    private Date updateTime;
}
