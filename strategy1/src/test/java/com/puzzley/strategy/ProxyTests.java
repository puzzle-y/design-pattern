package com.puzzley.strategy;


import com.puzzley.strategy.proxy.*;

/**
 * @Author yhj
 * @Date 2021/9/24
 **/
public class ProxyTests {

    public static void main(String[] args) {
        Test nativeTest = new TestImpl();
        Test decorator = new DecoratorTest(nativeTest);
        Test dynamicProxy = DynamicProxyTest.newProxyInstance(nativeTest);
        Test cglibProxy = CglibProxyTest.newProxyInstance(TestImpl.class);

        //预热一下；
        int preRunCount = 10000;

        long l1 = System.currentTimeMillis();
        System.out.println("JDK代理耗时测试开始");
        //
        runWithoutMonitor(dynamicProxy, preRunCount);
        System.out.println("耗时：" + (System.currentTimeMillis()-l1));

        long l2 = System.currentTimeMillis();
        System.out.println("CGLIB代理耗时测试开始");
        //
        runWithoutMonitor(cglibProxy, preRunCount);
        System.out.println("耗时：" + (System.currentTimeMillis()-l2));

        System.out.println("总耗时" + (System.currentTimeMillis()-l1));
    }


    private static void runWithoutMonitor(Test test, int runCount) {
        for (int i = 0; i < runCount; i++) {
            test.test(i);
        }
    }

}
