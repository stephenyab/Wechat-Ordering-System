package com.yang.restaurant.aspect;

import com.yang.restaurant.utils.AuthorizeUtil;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @ClassName ChiefAuthorizeAspect
 * @Description
 * @Author yang
 * @Date 2020/5/16 20:48
 * @Version 1.0
 */
@Aspect
@Component
public class ChiefAuthorizeAspect {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Pointcut("execution(public * com.yang.restaurant.controller.chief.Chief*.*(..))")
    public void verify() {
    }

    @Before("verify()")
    public void doVerify() {
        AuthorizeUtil.doUserVerify(redisTemplate);
    }
}
