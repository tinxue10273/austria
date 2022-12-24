package com.lemon.austria.common.error.exections;

import com.lemon.austria.common.error.enums.BusinessError;
import com.lemon.austria.common.error.enums.CommonError;
import lombok.Getter;

/**
 * @Author : garyhu480@gmail.com
 * @create 2022/12/18 05:06
 */
@Getter
public class CommonException extends RuntimeException{

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 错误信息
     */
    private String errorMessage;

    private CommonException commonException;

    public CommonException(String errorMsg) {
        super(errorMsg);
        this.code = CommonError.UNKNOWN.getCode();
        this.errorMessage = errorMsg;
        this.commonException = new CommonException(CommonError.UNKNOWN.getCode(), errorMsg);
    }

    public CommonException(Integer errorCode, String errorMsg) {
        super(errorMsg);
        this.code = errorCode;
        this.errorMessage = errorMsg;
        this.commonException = new CommonException(errorCode, errorMsg);
    }

    public CommonException(CommonError error) {
        super(error.getMessage());
        this.code = error.getCode();
        this.errorMessage = error.getMessage();
        this.commonException = new CommonException(error.getCode(), error.getMessage());
    }
}
