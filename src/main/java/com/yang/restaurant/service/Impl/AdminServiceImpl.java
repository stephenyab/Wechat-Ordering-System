package com.yang.restaurant.service.Impl;

import com.yang.restaurant.entity.AdminInfo;
import com.yang.restaurant.repository.AdminInfoRepository;
import com.yang.restaurant.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName AdminServiceImpl
 * @Description
 * @Author yang
 * @Date 2020/5/10 23:21
 * @Version 1.0
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminInfoRepository repository;

    @Override
    public AdminInfo findAdminInfoByName(String name) {
        return repository.findByAdminName(name);
    }
}
