package com.yang.restaurant.controller.customer;

import com.yang.restaurant.constant.CookieConstant;
import com.yang.restaurant.constant.RedisConstant;
import com.yang.restaurant.dto.RestInfoDTO;
import com.yang.restaurant.entity.UserInfo;
import com.yang.restaurant.service.RestInfoService;
import com.yang.restaurant.service.UserService;
import com.yang.restaurant.utils.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @ClassName CustomerIndexController
 * @Description
 * @Author yang
 * @Date 2020/5/13 10:28
 * @Version 1.0
 */
@Controller
@RequestMapping("/customer")
public class CustomerIndexController {

    @Autowired
    private UserService userService;

    @Autowired
    private RestInfoService restInfoService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @GetMapping("/index")
    public ModelAndView index(HttpServletRequest request,
                              Map<String, Object> map) {
        //从Cookie中获取到Customer的信息,然后从Redis中取出用户的openid
        Cookie cookie = CookieUtil.get(request, CookieConstant.USER);
        String openid = redisTemplate.opsForValue().get(String.format(RedisConstant.USER_PREFIX, cookie.getValue()));

        UserInfo userInfo = userService.findUserByOpenid(openid);
        RestInfoDTO restInfoDTO = restInfoService.findRestInfo();
        map.put("restInfoDTO", restInfoDTO);

        ModelAndView modelAndView = null;
        switch (userInfo.getUserIdentityEnum().getCode()) {
            case 0:
                modelAndView = new ModelAndView("customer/index", map);
                break;
            case 1:
                modelAndView = new ModelAndView("redirect:/waiter/index");
                break;
            case 2:
                modelAndView = new ModelAndView("redirect:/chief/index");
                break;
            case 3:
                modelAndView = new ModelAndView("redirect:/adminMobile/index");
        }

        return modelAndView;
    }

    @GetMapping("")
    public ModelAndView secondIndex() {
        return new ModelAndView("redirect:/customer/index");
    }
}
