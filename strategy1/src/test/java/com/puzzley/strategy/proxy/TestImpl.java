package com.puzzley.strategy.proxy;

/**
 * @Author yhj
 * @Date 2021/9/24
 **/
public class TestImpl implements Test {
    @Override
    public int test(int i) {
        return i+1;
    }
}
