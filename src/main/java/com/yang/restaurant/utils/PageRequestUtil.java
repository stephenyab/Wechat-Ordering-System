package com.yang.restaurant.utils;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName PageRequestUtil
 * @Description
 * @Author yang
 * @Date 2020/5/11 23:53
 * @Version 1.0
 */
public class PageRequestUtil {

    public static PageRequest getDescPageRequest(int page, int size) {
        List<Sort.Order> orders = new ArrayList<>();
        //设置时间倒序
        orders.add(new Sort.Order(Sort.Direction.DESC, "createTime"));
        Sort sort = Sort.by(orders);

        return PageRequest.of(page - 1, size, sort);
    }

    public static PageRequest getUserInfoDescPageRequest(int page, int size) {
        List<Sort.Order> orders = new ArrayList<>();
        //设置时间倒序
        orders.add(new Sort.Order(Sort.Direction.DESC, "registerTime"));
        Sort sort = Sort.by(orders);

        return PageRequest.of(page - 1, size, sort);
    }
}
