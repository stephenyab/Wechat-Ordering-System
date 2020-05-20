package com.yang.restaurant.controller.admin;

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

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName AdminDiscussController
 * @Description
 * @Author yang
 * @Date 2020/5/11 23:52
 * @Version 1.0
 */
@Controller
@RequestMapping("/admin/discuss")
public class AdminDiscussController {

    @Autowired
    private DiscussService discussService;

    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @Author yang
     * @Description 订单评价列表
     * @Date 2020/5/11 23:58
     * @Param [page, size, map]
     **/
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "5") Integer size,
                             Map<String, Object> map) {
        PageRequest request = PageRequestUtil.getDescPageRequest(page, size);
        Page<OrderDiscuss> orderDiscussPage = discussService.findAll(request);

        map.put("orderDiscussPage", orderDiscussPage);
        map.put("currentPage", page);
        map.put("size", size);

        return new ModelAndView("admin/discuss/list", map);
    }

    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @Author yang
     * @Description 好评列表
     * @Date 2020/5/12 0:00
     * @Param [page, size, map]
     **/
    @GetMapping("/good")
    public ModelAndView good(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "5") Integer size) {
        Map<String, Object> map = getMap(page, size, DiscussStatusEnum.GOOD.getCode());

        return new ModelAndView("admin/discuss/good", map);
    }

    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @Author yang
     * @Description 中评列表
     * @Date 2020/5/12 0:01
     * @Param [page, size, map]
     **/
    @GetMapping("/normal")
    public ModelAndView normal(@RequestParam(value = "page", defaultValue = "1") Integer page,
                               @RequestParam(value = "size", defaultValue = "5") Integer size) {

        Map<String, Object> map = getMap(page, size, DiscussStatusEnum.NORMAL.getCode());

        return new ModelAndView("admin/discuss/normal", map);
    }

    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @Author yang
     * @Description 差评列表
     * @Date 2020/5/12 0:03
     * @Param [page, size, map]
     **/
    @GetMapping("/bad")
    public ModelAndView bad(@RequestParam(value = "page", defaultValue = "1") Integer page,
                            @RequestParam(value = "size", defaultValue = "5") Integer size) {

        Map<String, Object> map = getMap(page, size, DiscussStatusEnum.BAD.getCode());

        return new ModelAndView("admin/discuss/bad", map);
    }

    private Map<String, Object> getMap(Integer page, Integer size, Integer discussStatus) {
        PageRequest request = PageRequestUtil.getDescPageRequest(page, size);
        Page<OrderDiscuss> orderDiscussPage = discussService.findDiscussByDiscussStatus(discussStatus, request);

        Map<String, Object> map = new HashMap<>();
        map.put("orderDiscussPage", orderDiscussPage);
        map.put("currentPage", page);
        map.put("size", size);

        return map;
    }
}
