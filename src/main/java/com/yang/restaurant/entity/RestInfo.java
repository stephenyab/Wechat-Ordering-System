package com.yang.restaurant.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @ClassName RestInfo
 * @Description 餐厅信息实体类
 * @Author yang
 * @Date 2020/5/10 22:49
 * @Version 1.0
 */
@Data
@Entity
public class RestInfo {

    @Id
    private String restId;

    private String restName;

    private String restPhone;

    private String restAddress;

    private String restDescription;

    private String restAnnouncement;

    private Integer deskNum;
}
