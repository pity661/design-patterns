package com.wenky.设计模式.观察者模式.watcher;

/**
 * @program: design-patterns
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-08-09 16:28
 */
public class Security implements Watcher {

  @Override
  public void update() {
    System.out.println("我是保镖");
  }
}
