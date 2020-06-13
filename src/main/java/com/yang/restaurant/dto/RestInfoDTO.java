package com.yang.restaurant.dto;

import lombok.Data;

/**
 * @ClassName RestInfoDTO
 * @Description
 * @Author yang
 * @Date 2020/5/10 23:39
 * @Version 1.0
 */
@Data
public class RestInfoDTO {

    private String restName;

    private String restPhone;

    private String restAddress;

    private Integer deskNum;

    private String restDescription;

    private String restAnnouncement;

    public boolean isEmpty() {
        return restName.isEmpty() || restPhone.isEmpty() || restAddress.isEmpty() || restDescription.isEmpty();
    }
}
