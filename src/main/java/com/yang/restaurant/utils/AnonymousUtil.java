package com.yang.restaurant.utils;

/**
 * @ClassName AnonymousUtil
 * @Description
 * @Author yang
 * @Date 2020/5/13 19:34
 * @Version 1.0
 */
public class AnonymousUtil {

    public static String anonymous(String username) {
        StringBuffer sb = new StringBuffer();

        if (username.length() > 2) {
            sb.append(username.charAt(0));
            for (int i = 1; i < username.length() - 1; i++) {
                sb.append("*");
            }
            sb.append(username.charAt(username.length() - 1));
        } else {
            sb.append(username.charAt(0));
            sb.append("*");
        }

        return sb.toString();
    }
}
