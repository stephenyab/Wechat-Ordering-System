package com.yang.restaurant.enums;

import lombok.Getter;

/**
 * @ClassName DiscussStatusEnum
 * @Description 评价等级枚举类
 * @Author yang
 * @Date 2020/5/10 22:52
 * @Version 1.0
 */
@Getter
public enum DiscussStatusEnum implements BaseEnum {
    GOOD(0, "好评"),
    NORMAL(1, "中等"),
    BAD(2, "差评");

    private Integer code;

    private String message;

    DiscussStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
