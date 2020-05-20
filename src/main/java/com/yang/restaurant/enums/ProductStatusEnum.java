package com.yang.restaurant.enums;

import lombok.Getter;

/**
 * @ClassName ProductStatusEnum
 * @Description 商品状态枚举类
 * @Author yang
 * @Date 2020/5/10 22:54
 * @Version 1.0
 */
@Getter
public enum ProductStatusEnum implements BaseEnum {
    UP(0, "在架"),
    DOWN(1, "下架");

    private Integer code;

    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
