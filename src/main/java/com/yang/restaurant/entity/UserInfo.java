package com.yang.restaurant.entity;

import com.yang.restaurant.enums.UserIdentityEnum;
import com.yang.restaurant.enums.UserSexEnum;
import com.yang.restaurant.utils.EnumUtil;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * @ClassName UserInfo
 * @Description 用户信息实体类
 * @Author yang
 * @Date 2020/5/10 22:50
 * @Version 1.0
 */
@Data
@Entity
@DynamicUpdate
public class UserInfo {

    @Id
    private String userOpenid;

    private String userName;

    private Integer userSex;

    private Integer userIdentity;

    private String userHeadimgurl;

    private String userPhone;

    private String userProvince;

    private String userCity;

    private String userCountry;

    private Date registerTime;

    private Date updateTime;

    public UserSexEnum getUserSexEnum() {
        return EnumUtil.getByCode(userSex, UserSexEnum.class);
    }

    public UserIdentityEnum getUserIdentityEnum() {
        return EnumUtil.getByCode(userIdentity, UserIdentityEnum.class);
    }
}
