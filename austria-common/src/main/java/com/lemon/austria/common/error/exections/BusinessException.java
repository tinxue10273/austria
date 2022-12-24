package com.lemon.austria.common.error.exections;

import com.lemon.austria.common.error.enums.BusinessError;
import lombok.Getter;

/**
 * @Author : garyhu480@gmail.com
 * @create 2022/12/18 05:06
 */
@Getter
public class BusinessException extends RuntimeException{

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 错误信息
     */
    private String errorMessage;

    private BusinessException businessException;

    public BusinessException(String errorMsg) {
        super(errorMsg);
        this.code = BusinessError.UNKNOWN.getCode();
        this.errorMessage = errorMsg;
        this.businessException = new BusinessException(BusinessError.UNKNOWN.getCode(), errorMsg);
    }

    public BusinessException(Integer errorCode, String errorMsg) {
        super(errorMsg);
        this.code = errorCode;
        this.errorMessage = errorMsg;
        this.businessException = new BusinessException(errorCode, errorMsg);
    }

    public BusinessException(BusinessError error) {
        super(error.getMessage());
        this.code = error.getCode();
        this.errorMessage = error.getMessage();
        this.businessException = new BusinessException(error.getCode(), error.getMessage());
    }
}
