package com.yang.restaurant.utils;

import java.util.Random;

/**
 * @ClassName KeyUtil
 * @Description
 * @Author yang
 * @Date 2020/5/10 23:31
 * @Version 1.0
 */
public class KeyUtil {

    /**
     * @return java.lang.String
     * @Author yang
     * @Description 生成唯一主键
     * @Date 2020/5/10 23:31
     * @Param []
     **/
    public static synchronized String getUniqueKey() {
        Random random = new Random();
        Integer a = random.nextInt(900000) + 100000;

        return System.currentTimeMillis() + String.valueOf(a);
    }

    /**
     * @return java.lang.String
     * @Author yang
     * @Description 生成唯一主键
     * @Date 2020/5/10 23:36
     * @Param []
     **/
    public static synchronized String getDiscussUniqueKey() {
        Random random = new Random();
        Integer a = random.nextInt(9000) + 1000;

        return System.currentTimeMillis() + String.valueOf(a);
    }

    public static synchronized String getProductUniqueKey() {
        Random random = new Random();
        Integer a = random.nextInt(900) + 1000;

        return String.valueOf(System.currentTimeMillis()).substring(0,4) + String.valueOf(a);
    }
}
