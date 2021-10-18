package com.puzzley.strategy;

import com.puzzley.strategy.constant.OrderType;
import com.puzzley.strategy.model.Order;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class Strategy1ApplicationTests {

    @Resource
    private OrderCancelHandlerFactory orderCancelHandlerFactory;

    @Test
    void contextLoads() {
        Order order = new Order();
        order.setId(10000000001L);
        order.setOrderType(OrderType.BOOKING);
        OrderCancelHandler orderCancelHandler = orderCancelHandlerFactory.getOrderCancelHandler(order.getOrderType());
        orderCancelHandler.handle(order);
    }

}
