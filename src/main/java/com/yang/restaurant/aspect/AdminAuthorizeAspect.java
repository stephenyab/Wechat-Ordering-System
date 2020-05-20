package com.yang.restaurant.aspect;

import com.yang.restaurant.dto.RestInfoDTO;
import com.yang.restaurant.exception.RestInfoEmptyException;
import com.yang.restaurant.service.RestInfoService;
import com.yang.restaurant.utils.AuthorizeUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @ClassName AdminAuthorizeAspect
 * @Description
 * @Author yang
 * @Date 2020/5/11 17:22
 * @Version 1.0
 */
@Aspect
@Component
public class AdminAuthorizeAspect {

    @Autowired
    private RestInfoService restInfoService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Pointcut("execution(public * com.yang.restaurant.controller.admin.Admin*.*(..))" +
            "&& !execution(public * com.yang.restaurant.controller.admin.AdminLoginController.*(..))")
    public void verify() {
    }

    @Before("verify()")
    public void doVerify() {
        AuthorizeUtil.doAdminVerify(redisTemplate);
    }

    @Pointcut("execution(public * com.yang.restaurant.controller.admin.AdminLoginController.login(..))")
    public void restInfoVerify() {
    }

    @After("restInfoVerify()")
    public void doRestInfoVerify() {
        RestInfoDTO restInfoDTO = restInfoService.findRestInfo();
        if (restInfoDTO == null || restInfoDTO.isEmpty()) {
            throw new RestInfoEmptyException();
        }

    }
}
