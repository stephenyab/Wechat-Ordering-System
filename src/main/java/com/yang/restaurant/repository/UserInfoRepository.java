package com.yang.restaurant.repository;

import com.yang.restaurant.entity.UserInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

/**
 * @ClassName UserInfoRepository
 * @Description 用户信息Jpa接口
 * @Author yang
 * @Date 2020/5/10 23:15
 * @Version 1.0
 */
public interface UserInfoRepository extends JpaRepository<UserInfo, String> {

    Page<UserInfo> findByUserIdentity(Integer userIdentity, Pageable pageable);

    UserInfo findByUserOpenid(String openid);

    UserInfo findByUserPhone(String phone);

    List<UserInfo> findByUserIdentity(Integer userIdentity);

    List<UserInfo> findAllByUserIdentityAndRegisterTimeBetween(Integer userIdentity, Date start, Date end);
}
