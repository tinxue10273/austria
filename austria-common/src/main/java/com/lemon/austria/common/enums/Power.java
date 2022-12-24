package com.lemon.austria.common.enums;

import com.lemon.austria.common.error.enums.CommonError;
import com.lemon.austria.common.error.exections.CommonException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

/**
 * 公共权限
 * @Author : garyhu480@gmail.com
 * @create 2022/12/18 05:40
 */
@Getter
@AllArgsConstructor
public enum Power {

    BAN(1, "无权限"),

    VIEW(2, "可查看"),

    EDIT(3, "可编辑"),

    DELETE(4, "可删除"),
    ;

    private Integer code;

    private String describe;

    public static Power of(Integer code){
        Power[] values = Power.values();
        for(Power val : values){
            if(Objects.equals(val.getCode(), code)){
                return val;
            }
        }
        throw new CommonException(CommonError.INVALID_ENUM);
    }
}
