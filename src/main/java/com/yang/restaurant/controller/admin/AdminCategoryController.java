package com.yang.restaurant.controller.admin;

import com.yang.restaurant.entity.ProductCategory;
import com.yang.restaurant.exception.CommonException;
import com.yang.restaurant.form.CategoryForm;
import com.yang.restaurant.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * @ClassName AdminCategoryController
 * @Description 管理员商品分类控制类
 * @Author yang
 * @Date 2020/5/11 21:20
 * @Version 1.0
 */
@Controller
@RequestMapping("/admin/category")
public class AdminCategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @Author yang
     * @Description 商品分类列表
     * @Date 2020/5/11 21:22
     * @Param [map]
     **/
    @GetMapping("/list")
    public ModelAndView list(Map<String, Object> map) {
        List<ProductCategory> productCategoryList = categoryService.findAll();
        map.put("categoryList", productCategoryList);
        return new ModelAndView("admin/category/list", map);
    }

    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @Author yang
     * @Description 商品分类详情
     * @Date 2020/5/11 21:43
     * @Param [categoryId, map]
     **/
    @GetMapping("/detail")
    public ModelAndView detail(@RequestParam(value = "categoryId", required = false) Integer categoryId,
                               Map<String, Object> map) {
        try {
            if (categoryId != null) {
                ProductCategory category = categoryService.findOne(categoryId);
                map.put("category", category);
            }
        } catch (CommonException e) {
            map.put("msg", e.getMessage());
            map.put("url", "list");
            return new ModelAndView("admin/common/error", map);
        }

        return new ModelAndView("admin/category/detail", map);
    }

    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @Author yang
     * @Description 保存商品分类信息
     * @Date 2020/5/11 21:44
     * @Param [form, bindingResult, map]
     **/
    @PostMapping("/save")
    public ModelAndView save(@Valid CategoryForm form,
                             BindingResult bindingResult,
                             Map<String, Object> map) {
        if (bindingResult.hasErrors()) {
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "detail");
            return new ModelAndView("admin/common/error", map);
        }

        ProductCategory productCategory = new ProductCategory();
        try {
            if (form.getCategoryId() != null) {
                productCategory = categoryService.findOne(form.getCategoryId());
            }
            BeanUtils.copyProperties(form, productCategory);
            categoryService.save(productCategory);
        } catch (Exception e) {
            map.put("msg", e.getMessage());
            map.put("url", "detail");
            return new ModelAndView("admin/common/error", map);
        }

        map.put("url", "list");
        return new ModelAndView("admin/common/success", map);
    }
}
