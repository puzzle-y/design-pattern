package com.puzzley.strategy.strategy;

import com.puzzley.strategy.base.StrategyFactory;

/**
 * @Author yhj
 * @Date 2021/10/8
 **/
//@Component
@Deprecated
public class OrderCancelHandlerFactory extends StrategyFactory<Integer, OrderCancelHandler> {
    public OrderCancelHandlerFactory() {
        super(OrderCancelHandler.class);
    }
}
