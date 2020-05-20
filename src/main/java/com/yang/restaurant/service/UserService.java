package com.yang.restaurant.service;

import com.yang.restaurant.entity.UserInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

/**
 * @ClassName UserInfoService
 * @Description
 * @Author yang
 * @Date 2020/5/10 23:34
 * @Version 1.0
 */
public interface UserService {

    Page<UserInfo> findUserByUserIdentity(Integer userIdentity, Pageable pageable);

    List<UserInfo> findUserByUserIdentity(Integer userIdentity);

    List<UserInfo> findAllCustomerThisMonth(Date start, Date end);

    List<UserInfo> findAllCustomerThisDay(Date start, Date end);

    UserInfo findUserByOpenid(String openid);

    UserInfo findUserByPhone(String phone);

    UserInfo save(UserInfo userInfo);
}
