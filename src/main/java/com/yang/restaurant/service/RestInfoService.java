package com.yang.restaurant.service;

import com.yang.restaurant.dto.RestInfoDTO;
import com.yang.restaurant.form.RestInfoForm;

/**
 * @ClassName RestInfoService
 * @Description
 * @Author yang
 * @Date 2020/5/10 23:34
 * @Version 1.0
 */
public interface RestInfoService {

    RestInfoDTO findRestInfo();

    void save(RestInfoForm restInfoForm);
}
