package com.yang.restaurant.controller.waiter;

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
 * @ClassName WaiterIndexController
 * @Description
 * @Author yang
 * @Date 2020/5/12 22:42
 * @Version 1.0
 */
@Controller
@RequestMapping("/waiter")
public class WaiterIndexController {

    @Autowired
    private ProjectUrl projectUrl;

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderDetailService orderDetailService;

    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @Author yang
     * @Description 所有完成烹饪订单列表
     * @Date 2020/5/12 22:43
     * @Param [map]
     **/
    @GetMapping("/index")
    public ModelAndView index(Map<String, Object> map) {
        List<OrderDTO> orderDTOList = orderService.findAllByOrderStatusAndPayStatus(OrderStatusEnum.COOKED.getCode(), PayStatusEnum.SUCCESS.getCode());

        for (int i = 0; i < orderDTOList.size(); i++) {
            orderDTOList.get(i).setOrderDetailList(orderDetailService.findOrderDetailByOrderId(orderDTOList.get(i).getOrderId()));
        }

        map.put("orderDTOList", orderDTOList);
        map.put("webSocketUrl", projectUrl.getWebSocketUrl());

        return new ModelAndView("/waiter/index", map);
    }
}
