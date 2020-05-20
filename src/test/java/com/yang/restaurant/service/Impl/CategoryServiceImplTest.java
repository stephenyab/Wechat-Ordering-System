package com.yang.restaurant.service.Impl;

import com.yang.restaurant.entity.ProductCategory;
import com.yang.restaurant.exception.CommonException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
class CategoryServiceImplTest {

    @Autowired
    private CategoryServiceImpl service;

    @Test
    void findOne() {
        try {
            ProductCategory category = service.findOne(100);
            log.info("category:{}", category);
        } catch (CommonException e) {
            log.error("error:{}-{}", e.getCode(), e.getMessage());
        }

    }

    @Test
    void findAll() {
        List<ProductCategory> productCategoryList = service.findAll();
        for (ProductCategory category : productCategoryList) {
            log.info("category:{}", category);
        }
    }

    @Test
    void findByCategoryTypeIn() {
        List<ProductCategory> productCategoryList = service.findByCategoryTypeIn(Arrays.asList(4,5));
        for (ProductCategory category : productCategoryList) {
            log.info("category:{}", category);
        }
    }

    @Test
    void save() {
    }
}
