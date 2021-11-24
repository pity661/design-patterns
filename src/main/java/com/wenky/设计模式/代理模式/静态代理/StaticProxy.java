package com.wenky.设计模式.代理模式.静态代理;

/**
 * @program: design-patterns
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2018-10-10 09:42
 */
public class StaticProxy implements StaticProxyInterface {
  private StaticProxyImpl staticProxyImpl;

  public StaticProxy(StaticProxyImpl staticProxyImpl) {
    this.staticProxyImpl = staticProxyImpl;
  }

  @Override
  public void queryInfo() {
    // 事务处理之前，可以执行一段代码
    System.out.println("事务处理之前...");
    // 调用委托类的方法
    staticProxyImpl.queryInfo();
    // 事务处理之后，可以执行一段代码
    System.out.println("事务处理之后...");
  }
}
