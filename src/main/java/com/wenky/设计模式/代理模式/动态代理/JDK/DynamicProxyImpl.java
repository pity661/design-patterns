package com.wenky.设计模式.代理模式.动态代理.JDK;

/**
 * @program: design-patterns
 * @description: 在代理模式中，叫做委托类，包含业务逻辑
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2018-10-12 15:57
 */
public class DynamicProxyImpl implements DynamicProxyInterface {
  @Override
  public void queryInfo() {
    System.out.println("代理模式 之 JDK的动态代理 -- DynamicProxyImpl实现类   查看信息...");
  }
}
