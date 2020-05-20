package com.yang.restaurant.service.Impl;

import com.yang.restaurant.entity.ProductCategory;
import com.yang.restaurant.enums.ResultEnum;
import com.yang.restaurant.exception.CommonException;
import com.yang.restaurant.repository.ProductCategoryRepository;
import com.yang.restaurant.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * @ClassName CategoryServiceImpl
 * @Description
 * @Author yang
 * @Date 2020/5/10 23:42
 * @Version 1.0
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ProductCategoryRepository repository;

    @Override
    public ProductCategory findOne(Integer categoryId) {
        ProductCategory category;

        try {
            category = repository.findById(categoryId).get();
        } catch (NoSuchElementException e) {
            throw new CommonException(ResultEnum.CATEGORY_ID_ERROR);
        }

        return category;
    }

    @Override
    public List<ProductCategory> findAll() {
        return repository.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return repository.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return repository.save(productCategory);
    }
}
