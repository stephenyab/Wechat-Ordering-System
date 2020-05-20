package com.yang.restaurant.repository;

import com.yang.restaurant.entity.AdminInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName AdminInfoRepository
 * @Description 管理员Jpa接口
 * @Author yang
 * @Date 2020/5/10 22:58
 * @Version 1.0
 */
public interface AdminInfoRepository extends JpaRepository<AdminInfo, String> {

    AdminInfo findByAdminName(String name);
}
