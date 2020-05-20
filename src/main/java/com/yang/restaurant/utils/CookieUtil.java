package com.yang.restaurant.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName CookieUtil
 * @Description
 * @Author yang
 * @Date 2020/3/16 22:25
 * @Version 1.0
 */
public class CookieUtil {

    /**
     * @return void
     * @Author yang
     * @Description 设置cookie
     * @Date 2020/3/16 22:26
     * @Param [response, name, value, maxAge]
     **/
    public static void set(HttpServletResponse response,
                           String name,
                           String value,
                           int maxAge) {
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
    }

    /**
     * @return void
     * @Author yang
     * @Description 从cookie中获取数据
     * @Date 2020/3/16 22:36
     * @Param [request, name]
     **/
    public static Cookie get(HttpServletRequest request,
                             String name) {
        Map<String, Cookie> cookieMap = readCookieMap(request);
        if (cookieMap.containsKey(name)) {
            return cookieMap.get(name);
        } else {
            return null;
        }
    }

    /**
     * @return java.util.Map<java.lang.String, javax.servlet.http.Cookie>
     * @Author yang
     * @Description 将cookie转换为Map格式
     * @Date 2020/3/16 22:39
     * @Param [request]
     **/
    private static Map<String, Cookie> readCookieMap(HttpServletRequest request) {
        Map<String, Cookie> cookieMap = new HashMap<>();
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                cookieMap.put(cookie.getName(), cookie);
            }
        }

        return cookieMap;
    }
}
