package com.yang.restaurant.controller.chief;

import com.yang.restaurant.config.ProjectUrl;
import com.yang.restaurant.dto.OrderDTO;
import com.yang.restaurant.enums.OrderStatusEnum;
import com.yang.restaurant.enums.PayStatusEnum;
import com.yang.restaurant.service.OrderDetailService;
import com.yang.restaurant.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * @ClassName ChiefIndexController
 * @Description
 * @Author yang
 * @Date 2020/5/12 21:41
 * @Version 1.0
 */
@Controller
@RequestMapping("/chief")
public class ChiefIndexController {

    @Autowired
    private ProjectUrl projectUrl;

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderDetailService orderDetailService;

    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @Author yang
     * @Description 所有已完成支付的新订单
     * @Date 2020/5/12 22:05
     * @Param [map]
     **/
    @GetMapping("/index")
    public ModelAndView index(Map<String, Object> map) {
        List<OrderDTO> orderDTOList = orderService.findAllByOrderStatusAndPayStatus(OrderStatusEnum.NEW.getCode(), PayStatusEnum.SUCCESS.getCode());

        for (int i = 0; i < orderDTOList.size(); i++) {
            orderDTOList.get(i).setOrderDetailList(orderDetailService.findOrderDetailByOrderId(orderDTOList.get(i).getOrderId()));
        }

        map.put("orderDTOList", orderDTOList);
        map.put("webSocketUrl", projectUrl.getWebSocketUrl());

        return new ModelAndView("/chief/index", map);
    }
}
