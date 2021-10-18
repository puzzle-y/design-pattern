package com.puzzley.strategy.base;

import com.google.common.collect.Maps;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Collection;
import java.util.Map;

/**
 * T 策略type的类型
 * S 具体策略接口，继承Strategy
 *
 * @Author yhj
 * @Date 2021/10/8
 **/
public class StrategyFactory<T, S extends Strategy<T>> implements InitializingBean, ApplicationContextAware {


    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    /**
     * 各种策略集合
     */
    private Map<T, S> strategyMap;

    /**
     * 策略的class对象（接口对象）
     */
    private final Class<S> strategyType;

    /**
     * 创建一个策略工厂
     *
     * @param strategyType 传入策略组的接口对象，具体S的class对象
     */
    public StrategyFactory(Class<S> strategyType) {
        this.strategyType = strategyType;
    }

    @Override
    public void afterPropertiesSet() {
        // 获取 Spring 容器中，所有 S 类型的 Bean
        Collection<S> strategies = applicationContext.getBeansOfType(strategyType).values();

        strategyMap = Maps.newHashMapWithExpectedSize(strategies.size());

        // 将所有 S 类型的 Bean 放入到 strategyMap 中
        for (final S strategy : strategies) {
            T flag = strategy.getFlag();
            strategyMap.put(flag, strategy);
        }
    }

    /**
     * 根据策略 Flag 获得对应的策略的 Bean
     *
     * @param flag 策略 flag
     * @return 策略的 Bean
     */
    public S getStrategy(T flag) {
        return strategyMap.get(flag);
    }

}
