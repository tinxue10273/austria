package com.lemon.austria.contract.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 包装返回体
 * @Author : garyhu480@gmail.com
 * @create 2022/12/18 04:11
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> implements LemonConstant {

    /**
     * 返回码 为0表示成功
     */
    private Integer code;

    /**
     * 返回详情
     */
    private String msg;

    /**
     * 返回详情
     */
    private T data;

    /**
     * 页面信息
     */
    private Page page;

    /**
     * 封装成功result
     * 不带页面信息
     * @param t
     * @param <T>
     * @return
     */
    public static <T> Result<T> success(T t){
        return Result.<T>builder()
                .code(SUCCESS_CODE)
                .msg(SUCCESS_DESCRIBE)
                .data(t)
                .page(null)
                .build();
    }

    /**
     * 封装成功result
     * 带页面信息
     * @param t
     * @param page
     * @param <T>
     * @return
     */
    public static <T> Result<T> success(T t, Page page){
        return Result.<T>builder()
                .code(SUCCESS_CODE)
                .msg(SUCCESS_DESCRIBE)
                .data(t)
                .page(page)
                .build();
    }

    /**
     * 封装失败result
     * @param code
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> Result<T> fail(Integer code, String msg){
        return Result.<T>builder()
                .code(code)
                .msg(msg)
                .build();
    }

    /**
     * 判断结果成功
     * @return
     */
    public Boolean successed(){
        return SUCCESS_CODE.equals(this.code);
    }

    /**
     * 判断结果失败
     * @return
     */
    public Boolean failed(){
        return null == this.code || this.code > SUCCESS_CODE;
    }
}
