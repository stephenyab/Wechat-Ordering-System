package com.yang.restaurant.form;

import lombok.Data;

/**
 * @ClassName DiscussForm
 * @Description
 * @Author yang
 * @Date 2020/5/13 19:33
 * @Version 1.0
 */
@Data
public class DiscussForm {

    private String orderId;

    private String openId;

    private String userName;

    private String discuss;

    private Integer status;

    private boolean anonymous;
}
