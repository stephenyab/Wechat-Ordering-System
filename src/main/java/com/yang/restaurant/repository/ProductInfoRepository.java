package com.yang.restaurant.repository;

import com.yang.restaurant.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @ClassName ProductInfoRepository
 * @Description 商品信息Jpa接口
 * @Author yang
 * @Date 2020/5/10 23:15
 * @Version 1.0
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {

    List<ProductInfo> findByProductStatus(Integer productStatus);
}
