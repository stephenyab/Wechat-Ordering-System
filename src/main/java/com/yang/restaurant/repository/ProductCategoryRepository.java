package com.yang.restaurant.repository;

import com.yang.restaurant.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @ClassName ProductCategoryRepository
 * @Description 分类Jpa接口
 * @Author yang
 * @Date 2020/5/10 23:14
 * @Version 1.0
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
