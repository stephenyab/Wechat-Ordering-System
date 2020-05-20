package com.yang.restaurant.service.Impl;

import com.yang.restaurant.converter.OrderMaster2OrderDTOConverter;
import com.yang.restaurant.dto.OrderDTO;
import com.yang.restaurant.entity.OrderMaster;
import com.yang.restaurant.entity.UserInfo;
import com.yang.restaurant.enums.ResultEnum;
import com.yang.restaurant.enums.UserIdentityEnum;
import com.yang.restaurant.exception.CommonException;
import com.yang.restaurant.repository.UserInfoRepository;
import com.yang.restaurant.service.UserService;
import com.yang.restaurant.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Description
 * @Author yang
 * @Date 2020/5/11 11:25
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserInfoRepository repository;

    @Override
    public Page<UserInfo> findUserByUserIdentity(Integer userIdentity, Pageable pageable) {
        return repository.findByUserIdentity(userIdentity, pageable);
    }

    @Override
    public List<UserInfo> findUserByUserIdentity(Integer userIdentity) {
        return repository.findByUserIdentity(userIdentity);
    }

    @Override
    public List<UserInfo> findAllCustomerThisMonth(Date start, Date end) {
        return repository.findAllByUserIdentityAndRegisterTimeBetween(UserIdentityEnum.CUSTOMER.getCode(), start, end);
    }

    @Override
    public List<UserInfo> findAllCustomerThisDay(Date start, Date end) {
        return repository.findAllByUserIdentityAndRegisterTimeBetween(UserIdentityEnum.CUSTOMER.getCode(), start, end);
    }

    @Override
    public UserInfo findUserByOpenid(String openid) {
        return repository.findByUserOpenid(openid);
    }

    @Override
    public UserInfo findUserByPhone(String phone) {
        return repository.findByUserPhone(phone);
    }

    @Override
    public UserInfo save(UserInfo userInfo) {
        return repository.save(userInfo);
    }
}
