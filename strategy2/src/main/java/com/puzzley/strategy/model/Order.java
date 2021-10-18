package com.puzzley.strategy.model;

import lombok.Data;

/**
 * @Author yhj
 **/
@Data
public class Order {
    /**
     * 订单号
     */
    Long id;
    /**
     * 订单类型
     */
    Integer orderType;
}
