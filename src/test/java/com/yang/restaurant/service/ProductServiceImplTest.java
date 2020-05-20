package com.yang.restaurant.service;

import com.yang.restaurant.entity.ProductInfo;
import com.yang.restaurant.exception.CommonException;
import com.yang.restaurant.service.Impl.ProductServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
class ProductServiceImplTest {

    @Autowired
    private ProductServiceImpl service;

    @Test
    void findOne() {
        try{
            ProductInfo productInfo = service.findOne("1230456");
            log.info("productInfo:{}", productInfo);
        }catch (CommonException e){
            log.error("error:{},{}",e.getCode(),e.getMessage());
        }

    }

    @Test
    void findUpAll() {
    }

    @Test
    void findAll() {
    }

    @Test
    void save() {
    }

    @Test
    void onSale() {
    }

    @Test
    void offSale() {
    }
}
