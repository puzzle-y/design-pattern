package com.puzzley.strategy.base;

/**
 * 策略抽象类
 *
 * @param <T>
 * @author yhj
 */
public interface Strategy<T> {

    /**
     * 获取具体的策略标志（区分是那种具体策略）
     *
     * @return 策略标志
     */
    T getFlag();
}
