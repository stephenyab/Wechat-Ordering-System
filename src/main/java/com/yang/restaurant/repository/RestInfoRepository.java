package com.yang.restaurant.repository;

import com.yang.restaurant.entity.RestInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName RestInfoRepository
 * @Description 餐厅信息Jpa接口
 * @Author yang
 * @Date 2020/5/10 23:15
 * @Version 1.0
 */
public interface RestInfoRepository extends JpaRepository<RestInfo, String> {

}
