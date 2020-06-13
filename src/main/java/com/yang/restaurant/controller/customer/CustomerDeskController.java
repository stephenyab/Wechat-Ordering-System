package com.yang.restaurant.controller.customer;

import com.yang.restaurant.constant.DeskConstant;
import com.yang.restaurant.constant.RedisConstant;
import com.yang.restaurant.dto.RestInfoDTO;
import com.yang.restaurant.entity.RestInfo;
import com.yang.restaurant.service.RestInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName CustomerDeskController
 * @Description
 * @Author 26232
 * @Date 2020/6/11 22:35
 * @Version 1.0
 */
@Slf4j
@Controller
@RequestMapping("/customer/desk")
public class CustomerDeskController {

    @Autowired
    private RestInfoService restInfoService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @Author 26232
     * @Description 0：座位空 1：座位有人
     * @Date 2020/6/12 8:48
     * @Param [map]
     **/
    @RequestMapping("/getAllDesk")
    public ModelAndView getAllDesk(Map<String, Object> map) {
        RestInfoDTO restInfoDTO = restInfoService.findRestInfo();
        Integer deskNum = restInfoDTO.getDeskNum();

        List<String> deskNumList = new ArrayList();

        String deskExist = redisTemplate.opsForValue().get("deskExist");
        if ("true".equals(deskExist)) {
            for (int i = 1; i <= deskNum; i++) {
                if (redisTemplate.opsForValue().get(String.format(DeskConstant.DESK_PREFIX, Integer.toString(i))).equals("0")) {
                    deskNumList.add(String.valueOf(i));
                }
            }
        } else {
            for (int i = 1; i <= deskNum; i++) {
                redisTemplate.opsForValue().set(String.format(DeskConstant.DESK_PREFIX, Integer.toString(i)), String.valueOf(0));
                deskNumList.add(String.valueOf(i));
            }
            redisTemplate.opsForValue().set("deskExist", "true");
        }

        map.put("deskNumList", deskNumList);

        return new ModelAndView("/customer/desk_choose", map);
    }
}
