package com.yang.restaurant.controller.admin;

import com.yang.restaurant.dto.OrderDTO;
import com.yang.restaurant.entity.UserInfo;
import com.yang.restaurant.enums.ResultEnum;
import com.yang.restaurant.exception.CommonException;
import com.yang.restaurant.service.OrderService;
import com.yang.restaurant.service.UserService;
import com.yang.restaurant.utils.DateUtil;
import com.yang.restaurant.utils.PageRequestUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @ClassName AdminIndexController
 * @Description
 * @Author yang
 * @Date 2020/5/11 17:13
 * @Version 1.0
 */
@Slf4j
@Controller
@RequestMapping("/admin")
public class AdminIndexController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public ModelAndView index(Map<String, Object> map) {
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date yesterday = dateFormat.parse(DateUtil.getYestoday());
            Date tomorrow = dateFormat.parse(DateUtil.getTomorrow());
            Date monthStart = dateFormat.parse(DateUtil.getMonthStart());

            List<OrderDTO> allOrderThisDay = orderService.findAllThisDay(yesterday, tomorrow);
            List<OrderDTO> allFinishOrderThisDay = orderService.findAllFinishThisDay(yesterday, tomorrow);
            List<OrderDTO> allOrderThisMonth = orderService.findAllThisMonth(monthStart, tomorrow);
            List<OrderDTO> allFinishOrderThisMonth = orderService.findAllFinishThisMonth(monthStart, tomorrow);
            List<UserInfo> allUserThisMonth = userService.findAllCustomerThisDay(monthStart, tomorrow);

            //计算当日销售额
            BigDecimal totalOrderAmountThisDay = new BigDecimal(BigInteger.ZERO);
            for (OrderDTO orderDTO : allFinishOrderThisDay) {
                totalOrderAmountThisDay = totalOrderAmountThisDay.add(orderDTO.getOrderAmount());
            }

            //计算本月销售额
            BigDecimal totalOrderAmountThisMonth = new BigDecimal(BigInteger.ZERO);
            for (OrderDTO orderDTO : allFinishOrderThisMonth) {
                totalOrderAmountThisMonth = totalOrderAmountThisMonth.add(orderDTO.getOrderAmount());
            }

            Date lastWeek = dateFormat.parse(DateUtil.getLastWeek());
            List<String> dateStringThisWeek = new ArrayList<>();
            List<Integer> orderNumThisWeek = new ArrayList<>();
            List<Integer> orderFinishThisWeek = new ArrayList<>();
            List<Integer> userNumThisWeek = new ArrayList<>();
            for (int i = 0; i < 7; i++) {
                dateStringThisWeek.add(dateFormat.format(lastWeek));
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(lastWeek);
                calendar.add(Calendar.DATE, 1);
                Date end = calendar.getTime();
                orderNumThisWeek.add(orderService.findAllThisDay(lastWeek, end).size());
                orderFinishThisWeek.add(orderService.findAllFinishThisDay(lastWeek, end).size());
                userNumThisWeek.add(userService.findAllCustomerThisDay(lastWeek, end).size());
                lastWeek = end;
            }

            Page<OrderDTO> orderDTOPage = orderService.findList(PageRequestUtil.getDescPageRequest(1, 8));

            map.put("allOrderThisDay", allOrderThisDay.size());
            map.put("allFinishOrderThisDay", allFinishOrderThisDay.size());
            map.put("allOrderThisMonth", allOrderThisMonth.size());
            map.put("allFinishOrderThisMonth", allFinishOrderThisMonth.size());
            map.put("totalOrderAmountThisDay", totalOrderAmountThisDay);
            map.put("totalOrderAmountThisMonth", totalOrderAmountThisMonth);
            map.put("allUserThisMonth", allUserThisMonth.size());

            map.put("dateStringThisWeek", dateStringThisWeek);
            map.put("orderNumThisWeek", orderNumThisWeek);
            map.put("orderFinishThisWeek", orderFinishThisWeek);
            map.put("userNumThisWeek", userNumThisWeek);

            map.put("latestEightOrder", orderDTOPage.getContent());
        } catch (ParseException e) {
            map.put("msg", ResultEnum.SYSTEM_TIME_ERROR);
            map.put("url", "/admin/order/list");
            return new ModelAndView("admin/common/error", map);
        }

        return new ModelAndView("/admin/index", map);
    }

    @RequestMapping("")
    public ModelAndView index1() {
        return new ModelAndView("redirect:/admin/index");
    }
}
