package com.yang.restaurant.service.Impl;

import com.yang.restaurant.entity.ProductInfo;
import com.yang.restaurant.enums.ProductStatusEnum;
import com.yang.restaurant.enums.ResultEnum;
import com.yang.restaurant.exception.CommonException;
import com.yang.restaurant.repository.ProductInfoRepository;
import com.yang.restaurant.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * @ClassName ProductServiceImpl
 * @Description
 * @Author yang
 * @Date 2020/5/11 12:22
 * @Version 1.0
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository repository;

    @Override
    public ProductInfo findOne(String productId) {
        ProductInfo productInfo;

        try {
            productInfo = repository.findById(productId).get();
        } catch (NoSuchElementException e) {
            throw new CommonException(ResultEnum.PRODUCT_NOT_EXIST);
        }

        return productInfo;
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return repository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }

    @Override
    public ProductInfo onSale(String productId) {
        ProductInfo productInfo;
        try {
            productInfo = repository.findById(productId).get();
        } catch (NoSuchElementException e) {
            throw new CommonException(ResultEnum.PRODUCT_NOT_EXIST);
        }

        if (productInfo.getProductStatusEnum() == ProductStatusEnum.UP) {
            throw new CommonException(ResultEnum.PRODUCT_STATUS_ERROR);
        }

        productInfo.setProductStatus(ProductStatusEnum.UP.getCode());

        return repository.save(productInfo);
    }

    @Override
    public ProductInfo offSale(String productId) {
        ProductInfo productInfo;
        try {
            productInfo = repository.findById(productId).get();
        } catch (NoSuchElementException e) {
            throw new CommonException(ResultEnum.PRODUCT_NOT_EXIST);
        }

        if (productInfo.getProductStatusEnum() == ProductStatusEnum.DOWN) {
            throw new CommonException(ResultEnum.PRODUCT_STATUS_ERROR);
        }

        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());

        return repository.save(productInfo);
    }
}
