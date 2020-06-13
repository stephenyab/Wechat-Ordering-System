package com.yang.restaurant.service.Impl;

import com.yang.restaurant.dto.RestInfoDTO;
import com.yang.restaurant.entity.RestInfo;
import com.yang.restaurant.enums.ResultEnum;
import com.yang.restaurant.exception.CommonException;
import com.yang.restaurant.form.RestInfoForm;
import com.yang.restaurant.repository.RestInfoRepository;
import com.yang.restaurant.repository.UserInfoRepository;
import com.yang.restaurant.service.RestInfoService;
import com.yang.restaurant.utils.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName RestInfoServiceImpl
 * @Description
 * @Author yang
 * @Date 2020/5/11 12:08
 * @Version 1.0
 */
@Slf4j
@Service
public class RestInfoServiceImpl implements RestInfoService {

    @Autowired
    private RestInfoRepository repository;

    @Override
    public RestInfoDTO findRestInfo() {
        List<RestInfo> restInfoList = repository.findAll();
        RestInfoDTO restInfoDTO = new RestInfoDTO();

        try {
            BeanUtils.copyProperties(restInfoList.get(0), restInfoDTO);
        } catch (IndexOutOfBoundsException e) {
            log.error("餐厅信息不存在");
            throw new CommonException(ResultEnum.REST_INFO_NOT_EXIST);
        }

        return restInfoDTO;
    }

    @Override
    public void save(RestInfoForm restInfoForm) {
        List<RestInfo> restInfoList = repository.findAll();
        RestInfo restInfo = new RestInfo();

        try {
            restInfo = restInfoList.get(0);
            String id = restInfo.getRestId();
            BeanUtils.copyProperties(restInfoForm, restInfo);
            restInfo.setRestId(id);
        } catch (IndexOutOfBoundsException e) {
            BeanUtils.copyProperties(restInfoForm, restInfo);
            restInfo.setRestId(KeyUtil.getUniqueKey());
        }

        repository.save(restInfo);
    }
}
