package com.yang.restaurant.enums;

import lombok.Getter;

/**
 * @ClassName ResultEnum
 * @Description 结果枚举类
 * @Author yang
 * @Date 2020/5/10 22:54
 * @Version 1.0
 */
@Getter
public enum ResultEnum {

    SUCCESS(0, "成功"),

    FAIL(1, "错误"),

    CATEGORY_ID_ERROR(2, "分类id错误"),

    REST_INFO_NOT_EXIST(3, "餐厅信息不存在"),

    PRODUCT_NOT_EXIST(4, "商品不存在"),

    PRODUCT_STATUS_ERROR(5, "商品状态错误"),

    ORDER_NOT_EXIST(6, "订单不存在"),

    ORDER_DETAIL_NOT_EXIST(7, "订单详情不存在"),

    ORDER_STATUS_ERROR(8, "订单状态错误"),

    ORDER_UPDATE_FAIL(9, "订单更新失败"),

    ORDER_PAY_STATUS_ERROR(10, "订单支付状态错误"),

    LOGIN_FAIL(11, "登录失败"),

    LOGOUT_SUCCESS(12, "登出系统成功"),

    ORDER_CANCEL_SUCCESS(13, "订单取消成功"),

    ORDER_FINISH_SUCCESS(14, "订单完结成功"),

    USER_NOT_EXIST(15, "用户不存在"),

    PARAM_ERROR(16, "参数不正确"),

    WECHAT_AUTHORIZE_ERROR(17, "微信网页授权错误"),

    SYSTEM_TIME_ERROR(18, "系统时间错误");

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
