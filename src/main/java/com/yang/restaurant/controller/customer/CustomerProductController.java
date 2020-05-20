package com.yang.restaurant.controller.customer;

import com.yang.restaurant.VO.CategoryVO;
import com.yang.restaurant.VO.ProductVO;
import com.yang.restaurant.dto.RestInfoDTO;
import com.yang.restaurant.entity.ProductCategory;
import com.yang.restaurant.entity.ProductInfo;
import com.yang.restaurant.service.CategoryService;
import com.yang.restaurant.service.ProductService;
import com.yang.restaurant.service.RestInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ClassName CustomerProductController
 * @Description
 * @Author yang
 * @Date 2020/5/13 19:35
 * @Version 1.0
 */
@Slf4j
@Controller
@RequestMapping("/customer/product")
public class CustomerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private RestInfoService restInfoService;

    @GetMapping("/list")
    public ModelAndView list(Map<String, Object> map) {
        List<ProductInfo> productInfoList = productService.findUpAll();

        List<Integer> categoryTypeList = productInfoList.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        List<CategoryVO> categoryVOList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList) {
            CategoryVO categoryVO = new CategoryVO();
            categoryVO.setCategoryName(productCategory.getCategoryName());
            categoryVO.setCategoryType(productCategory.getCategoryType());

            List<ProductVO> productVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productCategory.getCategoryType().equals(productInfo.getCategoryType())) {
                    ProductVO productVO = new ProductVO();
                    BeanUtils.copyProperties(productInfo, productVO);
                    productVOList.add(productVO);
                }
            }
            categoryVO.setProductVOList(productVOList);
            categoryVOList.add(categoryVO);
        }

        RestInfoDTO restInfoDTO = restInfoService.findRestInfo();

        map.put("categoryVOList", categoryVOList);
        map.put("totalProductNum", productInfoList.size() - 1);
        map.put("restInfoDTO", restInfoDTO);

        return new ModelAndView("/customer/product_list", map);
    }
}
