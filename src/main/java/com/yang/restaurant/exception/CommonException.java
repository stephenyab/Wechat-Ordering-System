package com.yang.restaurant.exception;

import com.yang.restaurant.enums.ResultEnum;
import lombok.Getter;

/**
 * @ClassName CommonException
 * @Description 统一异常类
 * @Author yang
 * @Date 2020/5/10 23:45
 * @Version 1.0
 */
@Getter
public class CommonException extends RuntimeException {

    Integer code;

    public CommonException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public CommonException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
