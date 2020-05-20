package com.yang.restaurant.enums;

import lombok.Getter;

/**
 * @ClassName OrderStatusEnum
 * @Description 订单状态枚举类
 * @Author yang
 * @Date 2020/5/10 22:53
 * @Version 1.0
 */
@Getter
public enum OrderStatusEnum implements BaseEnum {
    NEW(0, "新订单"),
    FINISH(1, "完结"),
    CANCEL(2, "已取消"),
    COOKING(3, "烹饪中"),
    COOKED(4, "烹饪完成"),
    SENDING(5, "送餐中");

    private Integer code;

    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
