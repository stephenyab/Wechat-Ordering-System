package com.yang.restaurant.service;

import com.yang.restaurant.entity.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @ClassName ProductService
 * @Description
 * @Author yang
 * @Date 2020/5/10 23:33
 * @Version 1.0
 */
public interface ProductService {

    //通过id查找商品
    ProductInfo findOne(String productId);

    //查看所有在架商品
    List<ProductInfo> findUpAll();

    //分页查询所有商品
    Page<ProductInfo> findAll(Pageable pageable);

    //添加商品
    ProductInfo save(ProductInfo productInfo);

    //商家商品
    ProductInfo onSale(String productId);

    //下架商品
    ProductInfo offSale(String productId);

}
