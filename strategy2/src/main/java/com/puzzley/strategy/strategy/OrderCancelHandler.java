package com.puzzley.strategy.strategy;


import com.puzzley.strategy.base.Strategy;
import com.puzzley.strategy.model.Order;

/**
 * 订单取消策略接口（）
 * @author yhj
 */
public interface OrderCancelHandler extends Strategy<Integer> {

    @Override
    default Integer getFlag() {
        return getOrderType();
    }

    /**
     * 获取订单类型（不同的订单类型，有不同的处理逻辑）
     *
     * @return 订单类型
     */
    Integer getOrderType();

    /**
     * 取消订单处理
     *
     * @param order 订单信息
     */
    void handle(Order order);
}
