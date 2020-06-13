package com.yang.restaurant.form;

import lombok.Data;

/**
 * @ClassName RestInfoForm
 * @Description
 * @Author yang
 * @Date 2020/5/10 23:41
 * @Version 1.0
 */
@Data
public class RestInfoForm {

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
