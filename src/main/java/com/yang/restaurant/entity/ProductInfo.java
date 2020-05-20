package com.yang.restaurant.entity;

import com.yang.restaurant.enums.ProductStatusEnum;
import com.yang.restaurant.utils.EnumUtil;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName ProductInof
 * @Description 商品信息实体类
 * @Author yang
 * @Date 2020/5/10 22:48
 * @Version 1.0
 */
@Data
@Entity
@DynamicUpdate
public class ProductInfo {

    @Id
    private String productId;

    private String productName;

    private BigDecimal productPrice;

    private String productDescription;

    private String productIcon;

    /**
     * 商品状态，0正常1下架
     */
    private Integer productStatus = ProductStatusEnum.UP.getCode();

    private Integer categoryType;

    private Date createTime;

    private Date updateTime;

    public ProductStatusEnum getProductStatusEnum() {
        return EnumUtil.getByCode(productStatus, ProductStatusEnum.class);
    }
}
