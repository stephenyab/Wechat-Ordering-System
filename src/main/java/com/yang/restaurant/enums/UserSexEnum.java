package com.yang.restaurant.enums;

import lombok.Getter;

/**
 * @ClassName UserSexEnum
 * @Description 用户性别枚举类
 * @Author yang
 * @Date 2020/5/10 22:56
 * @Version 1.0
 */
@Getter
public enum UserSexEnum implements BaseEnum {
    NEW(0, "未知"),
    FINISH(1, "男"),
    CANCEL(2, "女");

    private Integer code;

    private String message;

    UserSexEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
