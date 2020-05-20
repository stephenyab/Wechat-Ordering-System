package com.yang.restaurant.controller.admin;

import com.yang.restaurant.constant.CookieConstant;
import com.yang.restaurant.constant.RedisConstant;
import com.yang.restaurant.entity.AdminInfo;
import com.yang.restaurant.enums.ResultEnum;
import com.yang.restaurant.service.AdminService;
import com.yang.restaurant.utils.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName AdminLoginController
 * @Description 管理员登录登出控制类
 * @Author yang
 * @Date 2020/5/11 17:04
 * @Version 1.0
 */
@Controller
@RequestMapping("/admin/authorize")
public class AdminLoginController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @Author yang
     * @Description 管理员登录接口
     * @Date 2020/5/11 17:09
     * @Param [username, password, response, map]
     **/
    @RequestMapping("/login")
    public ModelAndView login(@RequestParam("username") String username,
                              @RequestParam("password") String password,
                              HttpServletResponse response,
                              Map<String, Object> map) {
        //1.username与数据库中的数据匹配
        AdminInfo adminInfo = adminService.findAdminInfoByName(username);
        if (adminInfo == null || !adminInfo.getPassword().equals(password)) {
            map.put("msg", ResultEnum.LOGIN_FAIL);
            map.put("url", "/admin/index");
            return new ModelAndView("admin/common/error", map);
        }

        //2.设置token至redis中
        String token = UUID.randomUUID().toString();
        Integer expire = RedisConstant.EXPIRE;

        redisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_PREFIX, token), username, expire, TimeUnit.SECONDS);

        //3.设置token至cookie
        CookieUtil.set(response, CookieConstant.TOKEN, token, expire);

        return new ModelAndView("redirect:/admin/index");
    }

    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @Author yang
     * @Description 管理员登出接口
     * @Date 2020/5/11 18:03
     * @Param [request, response, map]
     **/
    @GetMapping("/logout")
    public ModelAndView logout(HttpServletRequest request,
                               HttpServletResponse response,
                               Map<String, Object> map) {
        //1.从cookie中查询
        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
        if (cookie != null) {
            //2.清除redis
            redisTemplate.opsForValue().getOperations().delete(String.format(RedisConstant.TOKEN_PREFIX, cookie.getValue()));

            //3.清除cookie
            CookieUtil.set(response, CookieConstant.TOKEN, null, 0);
        }

        map.put("msg", ResultEnum.LOGOUT_SUCCESS);
        map.put("url", "/admin/index");

        return new ModelAndView("admin/common/success", map);
    }

    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @Author yang
     * @Description 跳转登录界面
     * @Date 2020/5/11 18:03
     * @Param []
     **/
    @GetMapping("/index")
    public ModelAndView index() {
        return new ModelAndView("/admin/login");
    }
}
