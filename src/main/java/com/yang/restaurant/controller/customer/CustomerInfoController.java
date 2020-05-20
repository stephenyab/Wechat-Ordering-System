package com.yang.restaurant.controller.customer;

import com.yang.restaurant.config.ProjectUrl;
import com.yang.restaurant.constant.CookieConstant;
import com.yang.restaurant.constant.RedisConstant;
import com.yang.restaurant.dto.OrderDTO;
import com.yang.restaurant.entity.UserInfo;
import com.yang.restaurant.enums.OrderStatusEnum;
import com.yang.restaurant.service.OrderService;
import com.yang.restaurant.service.UserService;
import com.yang.restaurant.utils.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName CustomerInfoController
 * @Description
 * @Author yang
 * @Date 2020/5/13 17:00
 * @Version 1.0
 */
@Slf4j
@Controller
@RequestMapping("/customer/info")
public class CustomerInfoController {

    @Autowired
    private ProjectUrl projectUrl;

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @RequestMapping("/message")
    public ModelAndView info(HttpServletRequest request,
                             Map<String, Object> map) {
        //从Cookie中获取到Customer的信息,然后从Redis中取出用户的openid
        Cookie cookie = CookieUtil.get(request, CookieConstant.USER);
        String openid = redisTemplate.opsForValue().get(String.format(RedisConstant.USER_PREFIX, cookie.getValue()));

        //统计订单笔数和消费金额
        List<OrderDTO> orderDTOList = orderService.findAll(openid);
        int totalOrderNum = orderDTOList.size();
        int totalOrderFinishNum = 0;
        BigDecimal totalOrderAmount = new BigDecimal(BigInteger.ZERO);
        for (OrderDTO orderDTO : orderDTOList) {
            if (orderDTO.getOrderStatus().equals(OrderStatusEnum.FINISH.getCode())) {
                totalOrderFinishNum++;
                totalOrderAmount = totalOrderAmount.add(orderDTO.getOrderAmount());
            }
        }

        UserInfo userInfo = userService.findUserByOpenid(openid);
        if (userInfo.getUserHeadimgurl().equals("")) {
            userInfo.setUserHeadimgurl("/images/default_head_img.png");
        }

        map.put("userInfo", userInfo);
        map.put("totalOrderNum", totalOrderNum);
        map.put("totalOrderFinishNum", totalOrderFinishNum);
        map.put("totalOrderAmount", totalOrderAmount);
        map.put("webSocketUrl", projectUrl.getWebSocketUrl());

        return new ModelAndView("customer/info/index");
    }

    @ResponseBody
    @PostMapping("/changePhone")
    public Object changePhone(String phone,
                              HttpServletRequest request) {
        Map<String, String> map = new HashMap<String, String>();

        //从Cookie中获取到Customer的信息,然后从Redis中取出用户的openid
        Cookie cookie = CookieUtil.get(request, CookieConstant.USER);
        String openid = redisTemplate.opsForValue().get(String.format(RedisConstant.USER_PREFIX, cookie.getValue()));

        //修改用户联系电话
        UserInfo userInfo = userService.findUserByOpenid(openid);
        if (userInfo != null) {
            userInfo.setUserPhone(phone);
            userService.save(userInfo);
            map.put("result", "success");
        } else {
            map.put("result", "fail");
        }

        return map;
    }
}
