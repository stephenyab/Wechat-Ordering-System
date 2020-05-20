package com.yang.restaurant.entity;

import com.yang.restaurant.enums.DiscussStatusEnum;
import com.yang.restaurant.utils.EnumUtil;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * @ClassName OrderDiscuss
 * @Description 订单评价实体类
 * @Author yang
 * @Date 2020/5/10 22:46
 * @Version 1.0
 */
@Data
@Entity
public class OrderDiscuss {

    @Id
    private String discussId;

    private String orderId;

    private String userOpenid;

    private String userName;

    private String userImgUrl;

    private Integer discussStatus;

    private String discussWord;

    private Date createTime;

    public DiscussStatusEnum getDiscussStatusEnum() {
        return EnumUtil.getByCode(discussStatus, DiscussStatusEnum.class);
    }
}
