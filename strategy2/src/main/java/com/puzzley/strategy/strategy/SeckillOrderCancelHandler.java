package com.puzzley.strategy.strategy;

import com.puzzley.strategy.constant.OrderType;
import com.puzzley.strategy.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Author yhj
 **/
@Slf4j
@Component
public class SeckillOrderCancelHandler implements OrderCancelHandler {
    @Override
    public Integer getOrderType() {
        return OrderType.SECKILL;
    }

    @Override
    public void handle(Order order) {
        log.info("秒杀订单取消成功，订单号：{}", order.getId());
    }
}
