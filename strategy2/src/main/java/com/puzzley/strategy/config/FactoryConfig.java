package com.puzzley.strategy.config;

import com.puzzley.strategy.base.StrategyFactory;
import com.puzzley.strategy.strategy.OrderCancelHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Author yhj
 * @Date 2021/10/8
 **/
@Component
public class FactoryConfig {
    @Bean
    public StrategyFactory<Integer, OrderCancelHandler> orderCancelHandlerFactory(){
        return new StrategyFactory<>(OrderCancelHandler.class);
    }
}
