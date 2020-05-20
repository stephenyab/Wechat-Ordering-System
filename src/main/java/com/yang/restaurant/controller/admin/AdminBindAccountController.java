package com.yang.restaurant.controller.admin;

import com.yang.restaurant.entity.UserInfo;
import com.yang.restaurant.enums.ResultEnum;
import com.yang.restaurant.enums.UserIdentityEnum;
import com.yang.restaurant.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * @ClassName AdminBindAccountController
 * @Description
 * @Author yang
 * @Date 2020/5/18 21:58
 * @Version 1.0
 */
@Controller
@RequestMapping("/admin/bind")
public class AdminBindAccountController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public ModelAndView staffList(Map<String, Object> map) {
        List<UserInfo> bindAdminList = userService.findUserByUserIdentity(UserIdentityEnum.ADMIN.getCode());

        map.put("bindAdminList", bindAdminList);
        return new ModelAndView("admin/restInfo/bindaccountlist", map);
    }

    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @Author yang
     * @Description 根据联系方式查找用户
     * @Date 2020/5/18 22:26
     * @Param [phone, map]
     **/
    @GetMapping("/find")
    public ModelAndView find(@RequestParam("phone") String phone,
                             Map<String, Object> map) {
        UserInfo userInfo = userService.findUserByPhone(phone);

        if (userInfo == null) {
            map.put("msg", ResultEnum.USER_NOT_EXIST.getMessage());
            map.put("url", "list");
            return new ModelAndView("admin/common/error", map);
        } else if (!userInfo.getUserIdentity().equals(UserIdentityEnum.CUSTOMER.getCode())) {
            map.put("msg", "账户状态不正确，请检查账户信息！");
            map.put("url", "list");
            return new ModelAndView("admin/common/error", map);
        }

        map.put("userInfo", userInfo);
        return new ModelAndView("admin/restInfo/bindaccount", map);
    }

    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @Author yang
     * @Description 绑定账户
     * @Date 2020/5/18 22:32
     * @Param [openid, map]
     **/
    @GetMapping("/bindAccount")
    public ModelAndView bind(@RequestParam("openid") String openid,
                             Map<String, Object> map) {
        UserInfo userInfo = userService.findUserByOpenid(openid);
        if (userInfo == null) {
            map.put("msg", ResultEnum.USER_NOT_EXIST.getMessage());
            map.put("url", "list");
            return new ModelAndView("admin/common/error", map);
        }

        userInfo.setUserIdentity(UserIdentityEnum.ADMIN.getCode());
        userService.save(userInfo);

        map.put("msg", "绑定账户成功！");
        map.put("url", "../list");
        return new ModelAndView("admin/common/success", map);
    }

    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @Author yang
     * @Description 解绑账户
     * @Date 2020/5/18 22:38
     * @Param [openid, map]
     **/
    @GetMapping("/unbindAccount")
    public ModelAndView unbind(@RequestParam("openid") String openid,
                               Map<String, Object> map) {
        UserInfo userInfo = userService.findUserByOpenid(openid);

        if (userInfo == null) {
            map.put("msg", ResultEnum.USER_NOT_EXIST.getMessage());
            map.put("url", "list");
            return new ModelAndView("admin/common/error", map);
        }

        if (!userInfo.getUserIdentity().equals(UserIdentityEnum.ADMIN.getCode())) {
            map.put("msg", "该账户未绑定");
            map.put("url", "list");
            return new ModelAndView("admin/common/error", map);
        }

        userInfo.setUserIdentity(UserIdentityEnum.CUSTOMER.getCode());
        userService.save(userInfo);

        map.put("msg", "账户解绑成功！");
        map.put("url", "list");
        return new ModelAndView("admin/common/success", map);
    }

}
