package com.yang.restaurant.handler;

import com.yang.restaurant.exception.AdminAuthorizeException;
import com.yang.restaurant.exception.AdminMobileException;
import com.yang.restaurant.exception.RestInfoEmptyException;
import com.yang.restaurant.exception.UserAuthorizeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName My
 * @Description
 * @Author yang
 * @Date 2020/5/11 17:31
 * @Version 1.0
 */
@Slf4j
@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(value = AdminAuthorizeException.class)
    public ModelAndView handleAdminAuthorizeException() {
        return new ModelAndView("redirect:/admin/authorize/index");
    }

    @ExceptionHandler(value = UserAuthorizeException.class)
    public ModelAndView handleCustomerAuthorizeException() {
        return new ModelAndView("redirect:/wechat/authorize");
    }

    @ExceptionHandler(value = RestInfoEmptyException.class)
    public ModelAndView handleRestInfoEmptyException() {
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "请完善餐厅的信息");
        map.put("url", "/admin/restInfo/index");

        return new ModelAndView("admin/common/error", map);
    }

    @ExceptionHandler(value = AdminMobileException.class)
    public ModelAndView handAdminMobileException() {
        return new ModelAndView("redirect:/customer/index");
    }
}
