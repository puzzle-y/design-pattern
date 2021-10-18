package com.puzzley.strategy;

import com.puzzley.strategy.constant.OrderType;
import com.puzzley.strategy.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Author yhj
 **/
@Component
@Slf4j
public class NormalOrderCancelHandler implements OrderCancelHandler {
    @Override
    public Integer getOrderType() {
        return OrderType.NORMAL;
    }

    @Override
    public void handle(Order order) {
        log.info("普通订单取消成功，订单号：{}", order.getId());
    }
}
