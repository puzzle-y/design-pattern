package com.puzzley.strategy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author yhj
 **/
@Component
public class OrderCancelHandlerFactory implements InitializingBean, ApplicationContextAware {

    /**
     * 应用程序上下文环境
     */
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    /**
     * 取消订单的策略集合
     */
    private static final Map<Integer, OrderCancelHandler> ORDER_CANCEL_HANDLER_MAP = new HashMap<>(8);

    @Override
    public void afterPropertiesSet() {
        this.applicationContext.getBeansOfType(OrderCancelHandler.class).values().forEach(handler -> {
            ORDER_CANCEL_HANDLER_MAP.put(handler.getOrderType(), handler);
        });
    }

    /**
     * 获取具体的策略
     * @param orderType 策略类型
     * @return OrderCancelHandler
     */
    public OrderCancelHandler getOrderCancelHandler(Integer orderType) {
        return ORDER_CANCEL_HANDLER_MAP.get(orderType);
    }

}
