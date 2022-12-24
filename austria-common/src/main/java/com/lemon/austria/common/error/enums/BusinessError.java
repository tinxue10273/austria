package com.lemon.austria.common.error.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 业务的错误码共6位
 * 第一位为项目序号
 * 第二位为模块序号
 * @Author : garyhu480@gmail.com
 * @create 2022/12/18 05:05
 */
@Getter
@AllArgsConstructor
public enum BusinessError {

    UNKNOWN(199999, "未知错误"),
    ;



    /**
     * 错误码
     */
    private Integer code;

    /**
     * 错误描述
     */
    private String message;
}
