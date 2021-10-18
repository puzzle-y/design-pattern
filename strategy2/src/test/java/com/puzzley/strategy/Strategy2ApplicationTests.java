package com.puzzley.strategy;

import com.puzzley.strategy.base.StrategyFactory;
import com.puzzley.strategy.constant.OrderType;
import com.puzzley.strategy.model.Order;
import com.puzzley.strategy.strategy.OrderCancelHandler;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class Strategy2ApplicationTests {

    /**
     * 使用@Resource，通过byName的方式自动注入策略工厂对象
     */
    @Resource
    private StrategyFactory<Integer, OrderCancelHandler> orderCancelHandlerFactory;

    @Test
    void contextLoads() {
        Order order = new Order();
        order.setId(10000000001L);
        order.setOrderType(OrderType.BOOKING);
        OrderCancelHandler orderCancelHandler = orderCancelHandlerFactory.getStrategy(order.getOrderType());
        orderCancelHandler.handle(order);
    }

}
