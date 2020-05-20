package com.yang.restaurant.VO;

import lombok.Data;

import java.util.List;

/**
 * @ClassName CategoryVO
 * @Description
 * @Author yang
 * @Date 2020/5/13 19:36
 * @Version 1.0
 */
@Data
public class CategoryVO {

    /**
     * 类目名称
     */
    private String categoryName;

    /**
     * 类目id
     */
    private Integer categoryType;

    /**
     * 类目下的所有商品详情
     */
    private List<ProductVO> productVOList;
}
