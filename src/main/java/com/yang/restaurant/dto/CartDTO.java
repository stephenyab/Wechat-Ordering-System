package com.yang.restaurant.dto;

import lombok.Data;

/**
 * @ClassName CartDTO
 * @Description
 * @Author yang
 * @Date 2020/5/10 23:37
 * @Version 1.0
 */
@Data
public class CartDTO {

    private String productId;

    private Integer productNum;

    public CartDTO(String productId, Integer productNum) {
        this.productId = productId;
        this.productNum = productNum;
    }
}
