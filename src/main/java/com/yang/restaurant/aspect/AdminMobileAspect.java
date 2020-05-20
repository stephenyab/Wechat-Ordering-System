package com.yang.restaurant.aspect;

import com.yang.restaurant.constant.CookieConstant;
import com.yang.restaurant.constant.RedisConstant;
import com.yang.restaurant.entity.UserInfo;
import com.yang.restaurant.enums.UserIdentityEnum;
import com.yang.restaurant.exception.AdminMobileException;
import com.yang.restaurant.service.UserService;
import com.yang.restaurant.utils.AuthorizeUtil;
import com.yang.restaurant.utils.CookieUtil;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName AdminMobileAspect
 * @Description
 * @Author yang
 * @Date 2020/5/19 19:10
 * @Version 1.0
 */
@Aspect
@Component
public class AdminMobileAspect {

    @Autowired
    private UserService userService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Pointcut("execution(public * com.yang.restaurant.controller.adminmobile.AdminMobile*.*(..))")
    public void verify() {
    }

    @After("verify()")
    public void doVerify() {
        AuthorizeUtil.doUserVerify(redisTemplate);

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //查询Cookie
        Cookie cookie = CookieUtil.get(request, CookieConstant.USER);

        //去redis查询
        String tokenValue = redisTemplate.opsForValue().get(String.format(RedisConstant.USER_PREFIX, cookie.getValue()));

        UserInfo userInfo = userService.findUserByOpenid(tokenValue);
        if (!userInfo.getUserIdentityEnum().getCode().equals(UserIdentityEnum.ADMIN.getCode())) {
            throw new AdminMobileException();
        }

    }
}
