package com.puzzley.strategy.proxy;

/**
 * @Author yhj
 * @Date 2021/9/24
 **/
public class DecoratorTest implements Test {

    private Test target;

    public DecoratorTest(Test target) {
        this.target = target;
    }

    @Override
    public int test(int i) {
        return target.test(i);
    }
}
