package com.wenky.设计模式.代理模式.动态代理.CGLIB;

/**
 * @program: design-patterns
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2018-10-22 20:52
 */
// public class CglibDynamicProxy implements MethodInterceptor {
//    // 目标实现类，也就是某个接口的实现类，这里的target_interface_implements，可以看做是一种抽象
//    private Object target_class;
//    // 创建代理对象
//    public Object getInstance(Object target_class){
//        this.target_class = target_class;
//        Enhancer enhancer = new Enhancer();
//        enhancer.setSuperclass(this.target_class.getClass());
//        // 回调方法
//        enhancer.setCallback(this);
//        // 创建代理对象
//        return enhancer.create();
//    }
//    // 回调方法
//    public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy proxy) throws
// Throwable {
//        // 事务处理之前，可以执行一段代码
//        System.out.println("事务处理之前...");
//        // 执行方法
//        proxy.invokeSuper(arg0, arg2);
//        // 事务处理之后，可以执行一段代码
//        System.out.println("事务处理之后...");
//        return null;
//    }
//
//    @Override
//    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy)
// throws Throwable {
//        return null;
//    }
// }
