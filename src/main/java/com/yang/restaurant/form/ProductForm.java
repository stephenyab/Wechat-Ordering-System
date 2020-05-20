package com.yang.restaurant.form;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @ClassName PrdocutForm
 * @Description
 * @Author yang
 * @Date 2020/5/12 13:28
 * @Version 1.0
 */
@Data
public class ProductForm {

    private String productId;

    private String productName;

    private BigDecimal productPrice;

    private Integer productStock;

    private String productDescription;

    private String productIcon;

    private Integer categoryType;
}
