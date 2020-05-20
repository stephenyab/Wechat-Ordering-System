package com.yang.restaurant.service;

import com.yang.restaurant.entity.ProductCategory;

import java.util.List;

/**
 * @ClassName CategoryService
 * @Description
 * @Author yang
 * @Date 2020/5/10 23:33
 * @Version 1.0
 */
public interface CategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
