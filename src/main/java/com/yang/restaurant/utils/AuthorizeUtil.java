package com.yang.restaurant.utils;

import com.yang.restaurant.constant.CookieConstant;
import com.yang.restaurant.constant.RedisConstant;
import com.yang.restaurant.exception.AdminAuthorizeException;
import com.yang.restaurant.exception.UserAuthorizeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName AuthorizeUtil
 * @Description
 * @Author yang
 * @Date 2020/5/11 17:23
 * @Version 1.0
 */
@Slf4j
public class AuthorizeUtil {

    public static void doAdminVerify(StringRedisTemplate redisTemplate) {
        doVerify(redisTemplate, new AdminAuthorizeException(), CookieConstant.TOKEN, RedisConstant.TOKEN_PREFIX);
    }

    public static void doUserVerify(StringRedisTemplate redisTemplate) {
        doVerify(redisTemplate, new UserAuthorizeException(), CookieConstant.USER, RedisConstant.USER_PREFIX);
    }

    public static void doVerify(StringRedisTemplate redisTemplate, RuntimeException runtimeException, String userIdentity, String redisIdentity) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //查询Cookie
        Cookie cookie = CookieUtil.get(request, userIdentity);
        if (cookie == null) {
            log.warn("【登录校验】Cookie中查不到token");
            throw runtimeException;
        }

        //去redis查询
        String tokenValue = redisTemplate.opsForValue().get(String.format(redisIdentity, cookie.getValue()));
        if (StringUtils.isEmpty(tokenValue)) {
            log.warn("【登录校验】Redis查不到token");
            throw runtimeException;
        }
    }
}
