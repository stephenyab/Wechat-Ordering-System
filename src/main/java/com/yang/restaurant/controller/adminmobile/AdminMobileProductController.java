package com.yang.restaurant.controller.adminmobile;

import com.yang.restaurant.entity.ProductInfo;
import com.yang.restaurant.form.ProductForm;
import com.yang.restaurant.service.ProductService;
import com.yang.restaurant.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Map;

/**
 * @ClassName AdminMobileProductController
 * @Description
 * @Author yang
 * @Date 2020/5/19 18:15
 * @Version 1.0
 */
@Controller
@RequestMapping("/adminMobile/product")
public class AdminMobileProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/save")
    public ModelAndView save(@Valid ProductForm productForm,
                             BindingResult bindingResult,
                             Map<String, Object> map) {
        if (bindingResult.hasErrors()) {
            map.put("msg", "请完整填写菜品信息");
            map.put("url", "/adminMobile/index");
            return new ModelAndView("customer/common/error", map);
        }

        ProductInfo productInfo = new ProductInfo();
        try {
            productForm.setProductId(KeyUtil.getProductUniqueKey());

            BeanUtils.copyProperties(productForm, productInfo);
            productService.save(productInfo);
        } catch (Exception e) {
            map.put("msg", "请完整填写菜品信息<br>" + e.getMessage());
            map.put("url", "/adminMobile/index");
            return new ModelAndView("customer/common/error", map);
        }

        map.put("msg", "新增菜品成功！");
        map.put("url", "/adminMobile/index");
        return new ModelAndView("customer/common/success", map);
    }
}
