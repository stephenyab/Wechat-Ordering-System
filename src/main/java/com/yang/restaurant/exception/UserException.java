package com.yang.restaurant.exception;

import com.yang.restaurant.enums.ResultEnum;
import lombok.Getter;

/**
 * @ClassName AdminException
 * @Description 用户操作异常类
 * @Author yang
 * @Date 2020/5/10 23:49
 * @Version 1.0
 */
@Getter
public class UserException extends RuntimeException {

    private Integer code;

    public UserException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public UserException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
