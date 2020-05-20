package com.yang.restaurant.VO;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @ClassName ProductVO
 * @Description
 * @Author yang
 * @Date 2020/5/13 19:36
 * @Version 1.0
 */
@Data
public class ProductVO {

    private String productId;

    private String productName;

    private BigDecimal productPrice;

    private String productDescription;

    private String productIcon;
}
