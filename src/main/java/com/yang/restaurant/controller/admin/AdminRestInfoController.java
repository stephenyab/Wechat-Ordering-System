package com.yang.restaurant.controller.admin;

import com.yang.restaurant.dto.RestInfoDTO;
import com.yang.restaurant.form.RestInfoForm;
import com.yang.restaurant.service.RestInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Map;

/**
 * @ClassName AdminRestInfoController
 * @Description
 * @Author yang
 * @Date 2020/5/12 13:49
 * @Version 1.0
 */
@Controller
@RequestMapping("/admin/restInfo")
public class AdminRestInfoController {

    @Autowired
    private RestInfoService restInfoService;

    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @Author yang
     * @Description 显示餐厅信息
     * @Date 2020/5/12 13:51
     * @Param [map]
     **/
    @GetMapping("/index")
    public ModelAndView index(Map<String, Object> map) {
        RestInfoDTO restInfoDTO = restInfoService.findRestInfo();

        map.put("restInfo", restInfoDTO);

        return new ModelAndView("admin/restInfo/index", map);
    }

    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @Author yang
     * @Description 更新餐厅信息
     * @Date 2020/5/12 13:51
     * @Param [form, bindingResult, map]
     **/
    @PostMapping("/save")
    public ModelAndView save(@Valid RestInfoForm form,
                             BindingResult bindingResult,
                             Map<String, Object> map) {
        if (bindingResult.hasErrors()) {
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "index");
            return new ModelAndView("admin/common/error", map);
        }

        if (form.isEmpty()) {
            map.put("msg", "请完整填写餐厅信息");
            map.put("url", "index");
            return new ModelAndView("admin/common/error", map);
        }

        restInfoService.save(form);

        map.put("msg", "餐厅信息更新成功");
        map.put("url", "index");
        return new ModelAndView("admin/common/success", map);
    }
}
