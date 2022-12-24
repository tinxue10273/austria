package com.lemon.austria.common.error.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 公共的错误码共4位
 * @Author : garyhu480@gmail.com
 * @create 2022/12/18 05:06
 */
@Getter
@AllArgsConstructor
public enum CommonError {
    // 请求方式错误 以1000开头
    REQUEST_METHOD_ERROR(1001, "请求方式错误"),

    // 请求参数错误 以2000开头
    REQUEST_PARAM_ERROR(2001, "请求方式错误"),

    // 数据库错误 以3000开头
    SELECT_FAIL(3001, "查询失败"),

    INSERT_FAIL(3002, "插入失败"),

    UPDATE_FAIL(3003, "更新失败"),

    SAVE_FAIL(3004, "保存失败"),

    DELETE_FAIL(3005, "删除失败"),

    // 不支持的枚举
    INVALID_ENUM(4001, "不支持改枚举"),

    // 未知错误 大兜底
    UNKNOWN(1999, "未知错误"),
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
