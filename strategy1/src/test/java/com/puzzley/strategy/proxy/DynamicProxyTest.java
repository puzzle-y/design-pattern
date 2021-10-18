package com.puzzley.strategy.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author yhj
 * @Date 2021/9/24
 **/
public class DynamicProxyTest implements InvocationHandler {

    private Test target;

    private DynamicProxyTest(Test target) {
        this.target = target;
    }

    public static Test newProxyInstance(Test target) {
        return (Test) Proxy
                .newProxyInstance(target.getClass().getClassLoader(),
                        target.getClass().getInterfaces(),
                        new DynamicProxyTest(target));

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(target, args);
    }
}
