package com.yang.restaurant.form;

import lombok.Data;

/**
 * @ClassName CategoryForm
 * @Description 商品分类信息前端对应类
 * @Author yang
 * @Date 2020/5/11 21:44
 * @Version 1.0
 */
@Data
public class CategoryForm {

    private Integer categoryId;

    private String categoryName;

    private Integer categoryType;
}
