package com.yang.restaurant.controller.customer;

import com.yang.restaurant.constant.CookieConstant;
import com.yang.restaurant.constant.RedisConstant;
import com.yang.restaurant.converter.OrderInfo2OrderDTOConverter;
import com.yang.restaurant.dto.OrderDTO;
import com.yang.restaurant.entity.OrderDiscuss;
import com.yang.restaurant.entity.UserInfo;
import com.yang.restaurant.enums.ResultEnum;
import com.yang.restaurant.exception.CommonException;
import com.yang.restaurant.exception.UserException;
import com.yang.restaurant.form.DiscussForm;
import com.yang.restaurant.service.DiscussService;
import com.yang.restaurant.service.OrderDetailService;
import com.yang.restaurant.service.OrderService;
import com.yang.restaurant.service.UserService;
import com.yang.restaurant.utils.AnonymousUtil;
import com.yang.restaurant.utils.CookieUtil;
import com.yang.restaurant.utils.PageRequestUtil;
import com.yang.restaurant.websocket.AdminWebSocket;
import com.yang.restaurant.websocket.ChiefWebSocket;
import com.yang.restaurant.websocket.WaiterWebSocket;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * @ClassName CustomerOrderController
 * @Description
 * @Author yang
 * @Date 2020/5/13 17:25
 * @Version 1.0
 */
@Slf4j
@Controller
@RequestMapping("/customer/order")
public class CustomerOrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @Autowired
    private DiscussService discussService;

    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private AdminWebSocket adminWebSocket;

    @Autowired
    private ChiefWebSocket chiefWebSocket;

    @Autowired
    private WaiterWebSocket waiterWebSocket;

    @GetMapping("/create")
    public ModelAndView create(HttpServletRequest request,
                               HttpServletResponse response,
                               Map<String, Object> map) {
        //从Cookie中获取到购物车信息
        Cookie carCookie = CookieUtil.get(request, "car");

        //从Cookie中获取到Customer的信息,然后从Redis中取出用户的openid
        Cookie userInfo = CookieUtil.get(request, CookieConstant.USER);
        String openid = redisTemplate.opsForValue().get(String.format(RedisConstant.USER_PREFIX, userInfo.getValue()));
        UserInfo buyerInfo = userService.findUserByOpenid(openid);

        //获得订单类
        OrderDTO orderDTO = OrderInfo2OrderDTOConverter.convert(carCookie, buyerInfo);

        OrderDTO createResult = orderService.create(orderDTO);

        //清空购物车
        CookieUtil.set(response, "car", null, 0);

        log.info("结果：{}", createResult.getOrderId());

        adminWebSocket.sendMessage("新订单");

        map.put("orderInfo", createResult);
        map.put("productNum", createResult.getOrderDetailList().size());

        return new ModelAndView("/customer/order/order_info", map);
    }

    @GetMapping("/pay")
    public ModelAndView pay(@RequestParam("orderId") String orderId,
                            Map<String, Object> map) {
        OrderDTO orderDTO;
        OrderDTO payResult;

        try {
            orderDTO = orderService.findOne(orderId);
            payResult = orderService.paid(orderDTO);
        } catch (CommonException e) {
            throw new UserException(e.getCode(), e.getMessage());
        }

        chiefWebSocket.sendMessage("order_paid");

        map.put("payResult", payResult);
        return new ModelAndView("customer/order/pay_result", map);
    }

    @GetMapping("/cancel")
    public ModelAndView cancel(@RequestParam("orderId") String orderId) {
        try {
            OrderDTO orderDTO = orderService.findOne(orderId);
            orderService.cancel(orderDTO);
        } catch (CommonException e) {
            log.error("【卖家端取消订单】发生异常{}", e);
            throw new UserException(e.getCode(), e.getMessage());
        }

        chiefWebSocket.sendMessage("cancel_order");
        waiterWebSocket.sendMessage("cancel_order");

        return new ModelAndView("redirect:/customer/order/list");
    }

    @GetMapping("/detail")
    public ModelAndView detail(@RequestParam("orderId") String orderId,
                               Map<String, Object> map) {
        OrderDTO orderDTO;
        try {
            orderDTO = orderService.findOne(orderId);
        } catch (CommonException e) {
            throw new UserException(e.getCode(), e.getMessage());
        }

        map.put("orderDetail", orderDTO);
        map.put("productNum", orderDTO.getOrderDetailList().size());

        return new ModelAndView("customer/order/successful_trade", map);
    }

    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "10") Integer size,
                             HttpServletRequest request,
                             Map<String, Object> map) {
        //从Cookie中获取到Customer的信息,然后从Redis中取出用户的openid
        Cookie userInfo = CookieUtil.get(request, CookieConstant.USER);
        String openid = redisTemplate.opsForValue().get(String.format(RedisConstant.USER_PREFIX, userInfo.getValue()));

        Page<OrderDTO> orderDTOPage = orderService.findList(openid, PageRequestUtil.getDescPageRequest(page, size));

        List<OrderDTO> orderDTOList = orderDTOPage.getContent();
        for (int i = 0; i < orderDTOList.size(); i++) {
            orderDTOList.get(i).setOrderDetailList(orderDetailService.findOrderDetailByOrderId(orderDTOList.get(i).getOrderId()));
        }

        map.put("size", size);
        map.put("currentPage", page);
        map.put("orderDTOList", orderDTOList);
        map.put("totalPages", orderDTOPage.getTotalPages());

        return new ModelAndView("/customer/order/order_list", map);
    }

    @GetMapping("/discuss")
    public ModelAndView discuss(@RequestParam("orderId") String orderId,
                                HttpServletRequest request,
                                Map<String, Object> map) {
        //从Cookie中获取到Customer的信息,然后从Redis中取出用户的openid
        Cookie user = CookieUtil.get(request, CookieConstant.USER);
        String openid = redisTemplate.opsForValue().get(String.format(RedisConstant.USER_PREFIX, user.getValue()));
        UserInfo userInfo = userService.findUserByOpenid(openid);

        ModelAndView modelAndView = null;

        if (discussService.findByOrderId(orderId) != null) {
            modelAndView = new ModelAndView("redirect:/customer/index");
        } else {
            OrderDTO orderDTO = orderService.findOne(orderId);

            map.put("orderDTO", orderDTO);
            map.put("openid", openid);
            map.put("userName", userInfo.getUserName());

            modelAndView = new ModelAndView("/customer/order/order_discuss", map);
        }

        return modelAndView;
    }

    @PostMapping("/discuss")
    public ModelAndView discuss(@Valid DiscussForm discussForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【订单评价】参数不正确，discussForm={}", discussForm);
            throw new UserException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }

        UserInfo userInfo = userService.findUserByOpenid(discussForm.getOpenId());

        OrderDiscuss orderDiscuss = new OrderDiscuss();
        orderDiscuss.setOrderId(discussForm.getOrderId());
        orderDiscuss.setUserOpenid(discussForm.getOpenId());

        orderDiscuss.setDiscussWord(discussForm.getDiscuss());
        orderDiscuss.setDiscussStatus(discussForm.getStatus());
        if (discussForm.isAnonymous()) {
            orderDiscuss.setUserName("匿名用户");
            orderDiscuss.setUserImgUrl("/images/default_head_img.png");
        } else {
            orderDiscuss.setUserName(AnonymousUtil.anonymous(discussForm.getUserName()));
            orderDiscuss.setUserImgUrl(userInfo.getUserHeadimgurl());
        }

        discussService.save(orderDiscuss);
        orderService.changeDiscussStatus(discussForm.getOrderId());

        return new ModelAndView("redirect:/customer/order/list");
    }

}
