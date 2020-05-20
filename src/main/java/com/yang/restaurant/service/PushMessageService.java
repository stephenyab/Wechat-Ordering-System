package com.yang.restaurant.service;

import com.yang.restaurant.dto.OrderDTO;
import com.yang.restaurant.dto.RestInfoDTO;

public interface PushMessageService {

    void orderStatus(OrderDTO orderDTO, RestInfoDTO restInfoDTO);
}
