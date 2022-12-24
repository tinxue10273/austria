package com.lemon.austria.common.enums;

import com.lemon.austria.common.error.enums.CommonError;
import com.lemon.austria.common.error.exections.BusinessException;
import com.lemon.austria.common.error.exections.CommonException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

/**
 * 公共数据行状态
 * @Author : garyhu480@gmail.com
 * @create 2022/12/18 05:40
 */
@Getter
@AllArgsConstructor
public enum IsDeleted {
    No(0, "未删除"),

    Yes(1, "删除"),
    ;

    private Integer code;

    private String describe;

    public static IsDeleted of(Integer code){
        IsDeleted[] values = IsDeleted.values();
        for(IsDeleted val : values){
            if(Objects.equals(val.getCode(), code)){
                return val;
            }
        }
        throw new CommonException(CommonError.INVALID_ENUM);
    }
}
