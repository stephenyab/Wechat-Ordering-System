package com.yang.restaurant.service;

import com.yang.restaurant.entity.AdminInfo;

/**
 * @ClassName AdminService
 * @Description
 * @Author yang
 * @Date 2020/5/10 23:20
 * @Version 1.0
 */
public interface AdminService {

    AdminInfo findAdminInfoByName(String name);
}
