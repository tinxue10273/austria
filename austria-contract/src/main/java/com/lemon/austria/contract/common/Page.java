package com.lemon.austria.contract.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 页面
 * @Author : garyhu480@gmail.com
 * @create 2022/12/18 04:11
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Page implements LemonConstant {

    /**
     * 页面大小
     */
    private Integer pageSize;

    /**
     * 页码
     */
    private Integer pageNo;

    /**
     * 总数
     */
    private Integer total;

    /**
     * 下一页的页面token
     */
    private String pageToken;

    /**
     * 是否还有下一页
     */
    private Boolean hasMore;
}
