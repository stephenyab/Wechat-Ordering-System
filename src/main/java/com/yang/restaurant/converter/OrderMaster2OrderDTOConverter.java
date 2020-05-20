package com.yang.restaurant.converter;

import com.yang.restaurant.dto.OrderDTO;
import com.yang.restaurant.entity.OrderMaster;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName OrderMaster2OrderDTOConverter
 * @Description
 * @Author yang
 * @Date 2020/5/11 16:22
 * @Version 1.0
 */
public class OrderMaster2OrderDTOConverter {

    public static OrderDTO convert(OrderMaster orderMaster) {
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster, orderDTO);
        return orderDTO;
    }

    public static List<OrderDTO> convert(List<OrderMaster> orderMasterList) {
        return orderMasterList.stream()
                .map(e -> convert(e))
                .collect(Collectors.toList());
    }
}
