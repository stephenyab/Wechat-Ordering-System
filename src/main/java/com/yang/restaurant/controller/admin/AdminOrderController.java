package com.yang.restaurant.controller.admin;

import com.yang.restaurant.config.ProjectUrl;
import com.yang.restaurant.dto.OrderDTO;
import com.yang.restaurant.entity.OrderDiscuss;
import com.yang.restaurant.enums.ResultEnum;
import com.yang.restaurant.exception.CommonException;
import com.yang.restaurant.service.DiscussService;
import com.yang.restaurant.service.OrderService;
import com.yang.restaurant.utils.PageRequestUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @ClassName AdminOrderController
 * @Description 管理员订单管理类
 * @Author yang
 * @Date 2020/5/12 11:41
 * @Version 1.0
 */
@Slf4j
@Controller
@RequestMapping("/admin/order")
public class AdminOrderController {

    @Autowired
    private ProjectUrl projectUrl;

    @Autowired
    private OrderService orderService;

    @Autowired
    private DiscussService discussService;

    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @Author yang
     * @Description 订单列表
     * @Date 2020/5/12 11:42
     * @Param [page, size, map]
     **/
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "5") Integer size,
                             Map<String, Object> map) {
        PageRequest request = PageRequestUtil.getDescPageRequest(page, size);

        Page<OrderDTO> orderDTOPage = orderService.findList(request);
        map.put("orderDTOPage", orderDTOPage);
        map.put("currentPage", page);
        map.put("size", size);
        map.put("webSocketUrl", projectUrl.getWebSocketUrl());
        return new ModelAndView("admin/order/list", map);
    }

    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @Author yang
     * @Description 取消订单
     * @Date 2020/5/12 11:43
     * @Param [orderId, map]
     **/
    @GetMapping("/cancel")
    public ModelAndView cancel(@RequestParam("orderId") String orderId,
                               Map<String, Object> map) {
        try {
            OrderDTO orderDTO = orderService.findOne(orderId);
            orderService.cancel(orderDTO);
        } catch (CommonException e) {
            log.error("【卖家端取消订单】发生异常{}", e);
            map.put("msg", e.getMessage());
            map.put("url", "list");
            return new ModelAndView("admin/common/error", map);
        }

        map.put("msg", ResultEnum.ORDER_CANCEL_SUCCESS.getMessage());
        map.put("url", "list");
        return new ModelAndView("admin/common/success");
    }

    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @Author yang
     * @Description 订单详情
     * @Date 2020/5/12 11:50
     * @Param [orderId, map]
     **/
    @GetMapping("/detail")
    public ModelAndView detail(@RequestParam("orderId") String orderId,
                               Map<String, Object> map) {
        OrderDTO orderDTO;
        try {
            orderDTO = orderService.findOne(orderId);
        } catch (CommonException e) {
            log.error("【卖家端查询订单详情】发生异常{}", e);
            map.put("msg", e.getMessage());
            map.put("url", "list");
            return new ModelAndView("admin/common/error", map);
        }

        OrderDiscuss orderDiscuss = discussService.findByOrderId(orderId);

        map.put("orderDTO", orderDTO);
        map.put("orderDiscuss", orderDiscuss);
        return new ModelAndView("admin/order/detail", map);
    }

    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @Author yang
     * @Description 完结订单
     * @Date 2020/5/12 12:25
     * @Param [orderId, map]
     **/
    @GetMapping("/finish")
    public ModelAndView finish(@RequestParam("orderId") String orderId,
                               Map<String, Object> map) {
        try {
            OrderDTO orderDTO = orderService.findOne(orderId);
            orderService.finish(orderDTO);
        } catch (CommonException e) {
            log.error("【卖家端完结订单】发生异常{}", e);
            map.put("msg", e.getMessage());
            map.put("url", "list");
            return new ModelAndView("admin/common/error", map);
        }

        map.put("msg", ResultEnum.ORDER_FINISH_SUCCESS.getMessage());
        map.put("url", "list");
        return new ModelAndView("admin/common/success");
    }
}
