package com.wenky.设计模式.代理模式.静态代理;

/**
 * @program: design-patterns
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2018-10-10 09:36
 **/
public class StaticProxyImpl implements StaticProxyInterface{
    @Override
    public void queryInfo() {
        System.out.println("代理模式 之 静态代理 -- StaticProxyImpl实现类   查看信息...");
    }
}
