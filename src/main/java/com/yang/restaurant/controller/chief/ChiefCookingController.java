package com.yang.restaurant.controller.chief;

import com.yang.restaurant.constant.CookieConstant;
import com.yang.restaurant.constant.RedisConstant;
import com.yang.restaurant.dto.OrderDTO;
import com.yang.restaurant.enums.OrderStatusEnum;
import com.yang.restaurant.service.OrderDetailService;
import com.yang.restaurant.service.OrderService;
import com.yang.restaurant.utils.CookieUtil;
import com.yang.restaurant.websocket.ChiefWebSocket;
import com.yang.restaurant.websocket.WaiterWebSocket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ChiefCookingController
 * @Description
 * @Author yang
 * @Date 2020/5/12 22:24
 * @Version 1.0
 */
@Controller
@RequestMapping("/chief/cook")
public class ChiefCookingController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private ChiefWebSocket chiefWebSocket;

    @Autowired
    private WaiterWebSocket waiterWebSocket;

    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @Author yang
     * @Description 烹饪中订单列表
     * @Date 2020/5/12 22:38
     * @Param [request, map]
     **/
    @GetMapping("/list")
    public ModelAndView list(HttpServletRequest request,
                             Map<String, Object> map) {
        //从Cookie中获取到Chief的信息,然后从Redis中取出用户的openid
        Cookie cookie = CookieUtil.get(request, CookieConstant.USER);
        String openid = redisTemplate.opsForValue().get(String.format(RedisConstant.USER_PREFIX, cookie.getValue()));

        List<OrderDTO> orderDTOList = orderService.findAllByChiefOpenidAndOrderStatus(openid, OrderStatusEnum.COOKING.getCode());

        for (int i = 0; i < orderDTOList.size(); i++) {
            orderDTOList.get(i).setOrderDetailList(orderDetailService.findOrderDetailByOrderId(orderDTOList.get(i).getOrderId()));
        }

        map.put("orderDTOList", orderDTOList);

        return new ModelAndView("/chief/list", map);
    }

    /**
     * @return java.lang.String
     * @Author yang
     * @Description 烹饪订单
     * @Date 2020/5/12 22:39
     * @Param [orderId, request]
     **/
    @GetMapping("/cooking")
    public String cooking(@RequestParam("orderId") String orderId,
                          HttpServletRequest request) {
        //从Cookie中获取到Customer的信息,然后从Redis中取出用户的openid
        Cookie cookie = CookieUtil.get(request, CookieConstant.USER);
        String openid = redisTemplate.opsForValue().get(String.format(RedisConstant.USER_PREFIX, cookie.getValue()));

        OrderDTO orderDTO = orderService.findOne(orderId);
        orderService.cooking(openid, orderDTO);

        chiefWebSocket.sendMessage(cookie.getValue());

        return "redirect:/chief/cook/list";
    }

    /**
     * @return java.lang.String
     * @Author yang
     * @Description 完成烹饪
     * @Date 2020/5/12 22:39
     * @Param [orderId]
     **/
    @GetMapping("/finishCook")
    public String cooking(@RequestParam("orderId") String orderId) {
        OrderDTO orderDTO = orderService.findOne(orderId);
        orderService.finishCook(orderDTO);

        waiterWebSocket.sendMessage("cook_finish");

        return "redirect:/chief/cook/list";
    }
}
