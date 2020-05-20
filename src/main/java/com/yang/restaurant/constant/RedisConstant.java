package com.yang.restaurant.constant;

/**
 * @ClassName RedisConstant
 * @Description 用户登录数据对应存储在redis中格式
 * @Author yang
 * @Date 2020/3/16 21:23
 * @Version 1.0
 */
public interface RedisConstant {

    String TOKEN_PREFIX = "token_%s";

    String USER_PREFIX = "user_%s";

    //过时时间2小时
    Integer EXPIRE = 7200;
}
