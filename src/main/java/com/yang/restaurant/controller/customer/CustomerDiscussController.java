package com.yang.restaurant.controller.customer;

import com.yang.restaurant.entity.OrderDiscuss;
import com.yang.restaurant.enums.DiscussStatusEnum;
import com.yang.restaurant.service.DiscussService;
import com.yang.restaurant.utils.PageRequestUtil;
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
 * @ClassName CustomerDiscussController
 * @Description
 * @Author yang
 * @Date 2020/5/13 16:32
 * @Version 1.0
 */
@Controller
@RequestMapping("/customer/discuss")
public class CustomerDiscussController {

    @Autowired
    private DiscussService discussService;

    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "10") Integer size,
                             @RequestParam(value = "discussType", defaultValue = "all") String discussType,
                             Map<String, Object> map) {
        Page<OrderDiscuss> orderDiscussPage = null;
        PageRequest request = PageRequestUtil.getDescPageRequest(page, size);

        switch (discussType) {
            case "all":
                orderDiscussPage = discussService.findAll(request);
                break;
            case "good":
                orderDiscussPage = discussService.findDiscussByDiscussStatus(DiscussStatusEnum.GOOD.getCode(), request);
                break;
            case "normal":
                orderDiscussPage = discussService.findDiscussByDiscussStatus(DiscussStatusEnum.NORMAL.getCode(), request);
                break;
            case "bad":
                orderDiscussPage = discussService.findDiscussByDiscussStatus(DiscussStatusEnum.BAD.getCode(), request);
                break;
        }

        map.put("size", size);
        map.put("currentPage", page);
        map.put("discussType", discussType);
        map.put("orderDiscussPage", orderDiscussPage);

        return new ModelAndView("/customer/discuss/list", map);
    }
}
