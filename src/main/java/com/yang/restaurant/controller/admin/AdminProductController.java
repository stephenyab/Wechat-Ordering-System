package com.yang.restaurant.controller.admin;

import com.yang.restaurant.config.ProjectUrl;
import com.yang.restaurant.entity.ProductCategory;
import com.yang.restaurant.entity.ProductInfo;
import com.yang.restaurant.exception.CommonException;
import com.yang.restaurant.form.ProductForm;
import com.yang.restaurant.service.CategoryService;
import com.yang.restaurant.service.ProductService;
import com.yang.restaurant.utils.KeyUtil;
import com.yang.restaurant.utils.PageRequestUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
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
 * @ClassName AdminProductController
 * @Description 管理员商品控制类
 * @Author yang
 * @Date 2020/5/12 12:31
 * @Version 1.0
 */
@Controller
@RequestMapping("/admin/product")
public class AdminProductController {

    @Autowired
    private ProjectUrl projectUrl;

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @Author yang
     * @Description 商品列表
     * @Date 2020/5/12 13:22
     * @Param [page, size, map]
     **/
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "5") Integer size,
                             Map<String, Object> map) {
        PageRequest request = PageRequestUtil.getDescPageRequest(page, size);
        Page<ProductInfo> productInfoPage = productService.findAll(request);

        map.put("productInfoPage", productInfoPage);
        map.put("currentPage", page);
        map.put("size", size);
        return new ModelAndView("admin/product/list", map);
    }

    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @Author yang
     * @Description 商品上架
     * @Date 2020/5/12 13:23
     * @Param [productId, map]
     **/
    @GetMapping("/on_sale")
    public ModelAndView onSale(@RequestParam("productId") String productId,
                               Map<String, Object> map) {
        try {
            productService.onSale(productId);
        } catch (CommonException e) {
            map.put("msg", e.getMessage());
            map.put("url", "list");
            return new ModelAndView("admin/common/error", map);
        }

        map.put("msg", "商品上架成功！");
        map.put("url", "list");
        return new ModelAndView("admin/common/success", map);
    }

    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @Author yang
     * @Description 商品下架
     * @Date 2020/5/12 13:24
     * @Param [productId, map]
     **/
    @GetMapping("/off_sale")
    public ModelAndView offSale(@RequestParam("productId") String productId,
                                Map<String, Object> map) {
        try {
            productService.offSale(productId);
        } catch (CommonException e) {
            map.put("msg", e.getMessage());
            map.put("url", "list");
            return new ModelAndView("admin/common/error", map);
        }

        map.put("msg", "商品下架成功！");
        map.put("url", "list");
        return new ModelAndView("admin/common/success", map);
    }

    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @Author yang
     * @Description 商品详情
     * @Date 2020/5/12 13:26
     * @Param [productId, map]
     **/
    @GetMapping("/detail")
    public ModelAndView index(@RequestParam(value = "productId", required = false) String productId,
                              Map<String, Object> map) {
        try {
            if (!StringUtils.isEmpty(productId)) {
                ProductInfo productInfo = productService.findOne(productId);
                map.put("productInfo", productInfo);
                map.put("productExist", "true");
            } else {
                map.put("productExist", "false");
            }
        } catch (CommonException e) {
            map.put("msg", e.getMessage());
            map.put("url", "list");
            return new ModelAndView("admin/common/error", map);
        }

        //查询所有的类目
        List<ProductCategory> categoryList = categoryService.findAll();
        map.put("categoryList", categoryList);
        map.put("webSocketUrl",projectUrl.getWebSocketUrl());

        return new ModelAndView("admin/product/detail", map);
    }

    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @Author yang
     * @Description 新增商品
     * @Date 2020/5/12 13:30
     * @Param [productForm, bindingResult, map]
     **/
    @PostMapping("/save")
    public ModelAndView save(@Valid ProductForm productForm,
                             BindingResult bindingResult,
                             Map<String, Object> map) {
        if (bindingResult.hasErrors()) {
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "detail");
            return new ModelAndView("admin/common/error", map);
        }

        ProductInfo productInfo = new ProductInfo();
        try {
            //如果productId为空，说明是新增
            if (!StringUtils.isEmpty(productForm.getProductId())) {
                productInfo = productService.findOne(productForm.getProductId());
            } else {
                productForm.setProductId(KeyUtil.getProductUniqueKey());
            }

            BeanUtils.copyProperties(productForm, productInfo);
            productService.save(productInfo);
        } catch (Exception e) {
            map.put("msg", e.getMessage());
            map.put("url", "detail");
            return new ModelAndView("admin/common/error", map);
        }

        map.put("url", "list");
        return new ModelAndView("admin/common/success", map);
    }
}
