package com.yang.restaurant.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @ClassName AdminInfo
 * @Description 管理员实体类
 * @Author yang
 * @Date 2020/5/10 22:43
 * @Version 1.0
 */
@Data
@Entity
public class AdminInfo {

    @Id
    private String adminId;

    private String adminName;

    private String password;
}
