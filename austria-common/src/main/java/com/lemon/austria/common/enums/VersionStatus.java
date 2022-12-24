package com.lemon.austria.common.enums;

import com.lemon.austria.common.error.enums.CommonError;
import com.lemon.austria.common.error.exections.CommonException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

/**
 * 公共版本状态
 * @Author : garyhu480@gmail.com
 * @create 2022/12/18 05:40
 */
@Getter
@AllArgsConstructor
public enum VersionStatus {
    INIT(1, "初始化"),

    DRAFT(2, "草稿"),

    ONLINE(3, "在线"),

    OFFLINE(4, "下线"),

    INVALID(5, "无效"),

    DELETED(6, "已删除"),
    ;

    private Integer code;

    private String describe;

    public static VersionStatus of(Integer code){
        VersionStatus[] values = VersionStatus.values();
        for(VersionStatus val : values){
            if(Objects.equals(val.getCode(), code)){
                return val;
            }
        }
        throw new CommonException(CommonError.INVALID_ENUM);
    }
}
