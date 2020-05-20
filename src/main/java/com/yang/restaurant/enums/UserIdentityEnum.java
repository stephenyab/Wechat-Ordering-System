package com.yang.restaurant.enums;

import lombok.Getter;

/**
 * @ClassName UserIdentityEnum
 * @Description 用户身份枚举类
 * @Author yang
 * @Date 2020/5/10 22:55
 * @Version 1.0
 */
@Getter
public enum UserIdentityEnum implements BaseEnum {

    CUSTOMER(0, "顾客"),

    WAITER(1, "服务员"),

    CHIEF(2, "厨师"),

    ADMIN(3, "管理员");

    private Integer code;

    private String message;

    UserIdentityEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
