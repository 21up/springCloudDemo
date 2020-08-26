package com.wen.cloud.domain;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by 21up on 2020/8/19
 */
@Data
public class Account {
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 总额度
     */
    private BigDecimal total;

    /**
     * 已用额度
     */
    private BigDecimal used;

    /**
     * 剩余额度
     */
    private BigDecimal residue;
}
