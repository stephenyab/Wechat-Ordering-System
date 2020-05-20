package com.yang.restaurant.controller.admin;

import com.yang.restaurant.dto.OrderDTO;
import com.yang.restaurant.entity.UserInfo;
import com.yang.restaurant.enums.ResultEnum;
import com.yang.restaurant.enums.UserIdentityEnum;
import com.yang.restaurant.exception.CommonException;
import com.yang.restaurant.service.OrderService;
import com.yang.restaurant.service.UserService;
import com.yang.restaurant.utils.PageRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

/**
 * @ClassName AdminUserController
 * @Description
 * @Author yang
 * @Date 2020/5/12 14:17
 * @Version 1.0
 */
@Controller
@RequestMapping("/admin/user")
public class AdminUserController {

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @Author yang
     * @Description 用户列表
     * @Date 2020/5/12 14:19
     * @Param [page, size, map]
     **/
    @GetMapping("/customer/list")
    public ModelAndView customerList(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                     @RequestParam(value = "size", defaultValue = "5") Integer size,
                                     Map<String, Object> map) {
        PageRequest request = PageRequestUtil.getUserInfoDescPageRequest(page, size);
        Page<UserInfo> userInfoPage = userService.findUserByUserIdentity(UserIdentityEnum.CUSTOMER.getCode(), request);
        map.put("customerPage", userInfoPage);
        map.put("currentPage", page);
        map.put("size", size);
        return new ModelAndView("admin/user/customer", map);
    }

    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @Author yang
     * @Description 用户详细信息
     * @Date 2020/5/12 14:50
     * @Param [openid, map]
     **/
    @GetMapping("/customer/detail")
    public ModelAndView customerDetail(@RequestParam("openid") String openid,
                                       Map<String, Object> map) {
        UserInfo userInfo = userService.findUserByOpenid(openid);
        if (userInfo == null) {
            map.put("msg", "用户不存在");
            map.put("url", "list");
            return new ModelAndView("admin/common/error", map);
        }

        List<OrderDTO> orderDTOList = orderService.findAll(openid);
        Integer orderNum = orderDTOList.size();
        BigDecimal orderTotalAmount = new BigDecimal(BigInteger.ZERO);
        for (OrderDTO orderDTO : orderDTOList) {
            orderTotalAmount = orderDTO.getOrderAmount().add(orderTotalAmount);
        }

        map.put("userInfo", userInfo);
        map.put("orderNum", orderNum);
        map.put("orderTotalAmount", orderTotalAmount);
        map.put("orderDTOList", orderDTOList);

        return new ModelAndView("admin/user/detail", map);
    }

    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @Author yang
     * @Description 员工列表
     * @Date 2020/5/12 14:51
     * @Param [map]
     **/
    @GetMapping("/staff/list")
    public ModelAndView staffList(Map<String, Object> map) {
        List<UserInfo> waiterList = userService.findUserByUserIdentity(UserIdentityEnum.WAITER.getCode());
        List<UserInfo> chiefList = userService.findUserByUserIdentity(UserIdentityEnum.CHIEF.getCode());

        map.put("waiterList", waiterList);
        map.put("chiefList", chiefList);
        return new ModelAndView("admin/user/staff", map);
    }

    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @Author yang
     * @Description 解雇员工
     * @Date 2020/5/12 14:58
     * @Param [openid, map]
     **/
    @GetMapping("/staff/fire")
    public ModelAndView fire(@RequestParam("openid") String openid,
                             Map<String, Object> map) {
        UserInfo userInfo = userService.findUserByOpenid(openid);

        if (userInfo == null) {
            map.put("msg", ResultEnum.USER_NOT_EXIST.getMessage());
            map.put("url", "list");
            return new ModelAndView("admin/common/error", map);
        }

        if (userInfo.getUserIdentity().equals(UserIdentityEnum.CUSTOMER.getCode())) {
            map.put("msg", "该用户不是餐厅员工");
            map.put("url", "list");
            return new ModelAndView("admin/common/error", map);
        }

        userInfo.setUserIdentity(UserIdentityEnum.CUSTOMER.getCode());
        userService.save(userInfo);

        map.put("msg", "员工解雇成功！");
        map.put("url", "list");
        return new ModelAndView("admin/common/success", map);
    }

    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @Author yang
     * @Description 员工换岗
     * @Date 2020/5/12 15:02
     * @Param [openid, map]
     **/
    @GetMapping("/staff/change")
    public ModelAndView change(@RequestParam("openid") String openid,
                               Map<String, Object> map) {
        UserInfo userInfo = userService.findUserByOpenid(openid);

        if (userInfo == null) {
            map.put("msg", ResultEnum.USER_NOT_EXIST.getMessage());
            map.put("url", "list");
            return new ModelAndView("admin/common/error", map);
        }

        if (userInfo.getUserIdentity().equals(UserIdentityEnum.CUSTOMER.getCode())) {
            map.put("msg", "该用户不是餐厅员工");
            map.put("url", "list");
            return new ModelAndView("admin/common/error", map);
        } else if (userInfo.getUserIdentity().equals(UserIdentityEnum.WAITER.getCode())) {
            userInfo.setUserIdentity(UserIdentityEnum.CHIEF.getCode());
        } else {
            userInfo.setUserIdentity(UserIdentityEnum.WAITER.getCode());
        }

        userService.save(userInfo);

        map.put("msg", "员工更换岗位成功！");
        map.put("url", "list");
        return new ModelAndView("admin/common/success", map);
    }

    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @Author yang
     * @Description 通过联系方式查找用户
     * @Date 2020/5/12 15:03
     * @Param [phone, map]
     **/
    @GetMapping("/staff/find")
    public ModelAndView find(@RequestParam("phone") String phone,
                             Map<String, Object> map) {
        UserInfo userInfo = userService.findUserByPhone(phone);

        if (userInfo == null) {
            map.put("msg", ResultEnum.USER_NOT_EXIST.getMessage());
            map.put("url", "list");
            return new ModelAndView("admin/common/error", map);
        } else if (!userInfo.getUserIdentity().equals(UserIdentityEnum.CUSTOMER.getCode())) {
            map.put("msg", "该用户已是餐厅员工");
            map.put("url", "list");
            return new ModelAndView("admin/common/error", map);
        }

        map.put("userInfo", userInfo);
        return new ModelAndView("admin/user/info", map);
    }

    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @Author yang
     * @Description 雇佣服务员
     * @Date 2020/5/12 15:04
     * @Param [openid, map]
     **/
    @GetMapping("/staff/employ/waiter")
    public ModelAndView employWaiter(@RequestParam("openid") String openid,
                                     Map<String, Object> map) {
        UserInfo userInfo = userService.findUserByOpenid(openid);
        if (userInfo == null) {
            map.put("msg", ResultEnum.USER_NOT_EXIST.getMessage());
            map.put("url", "list");
            return new ModelAndView("admin/common/error", map);
        }

        userInfo.setUserIdentity(UserIdentityEnum.WAITER.getCode());
        userService.save(userInfo);

        map.put("msg", "雇佣服务员成功！");
        map.put("url", "../list");
        return new ModelAndView("admin/common/success", map);
    }

    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @Author yang
     * @Description 雇佣厨师
     * @Date 2020/5/12 15:05
     * @Param [openid, map]
     **/
    @GetMapping("/staff/employ/chief")
    public ModelAndView employChief(@RequestParam("openid") String openid,
                                    Map<String, Object> map) {
        UserInfo userInfo = userService.findUserByOpenid(openid);
        if (userInfo == null) {
            map.put("msg", ResultEnum.USER_NOT_EXIST.getMessage());
            map.put("url", "list");
            return new ModelAndView("admin/common/error", map);
        }

        userInfo.setUserIdentity(UserIdentityEnum.CHIEF.getCode());
        userService.save(userInfo);

        map.put("msg", "雇佣厨师成功！");
        map.put("url", "../list");
        return new ModelAndView("admin/common/success", map);
    }
}
