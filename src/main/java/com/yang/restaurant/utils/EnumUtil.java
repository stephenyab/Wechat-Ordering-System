package com.yang.restaurant.utils;

import com.yang.restaurant.enums.BaseEnum;

/**
 * @ClassName EnumUtil
 * @Description 获取枚举类
 * @Author yang
 * @Date 2020/5/10 22:56
 * @Version 1.0
 */
public class EnumUtil {

    public static <T extends BaseEnum> T getByCode(Integer code, Class<T> enumClass) {
        for (T each : enumClass.getEnumConstants()) {
            if (code.equals(each.getCode())) {
                return each;
            }
        }
        return null;
    }
}
