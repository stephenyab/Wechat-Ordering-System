package com.yang.restaurant.enums;

import lombok.Getter;

/**
 * @ClassName PayStatusEnum
 * @Description 支付状态枚举类
 * @Author yang
 * @Date 2020/5/10 22:53
 * @Version 1.0
 */
@Getter
public enum PayStatusEnum implements BaseEnum {
    WAIT(0, "未支付"),
    SUCCESS(1, "支付成功"),
    REFUND_SUCCESSFUL(2,"退款成功")
    ;

    private Integer code;

    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
