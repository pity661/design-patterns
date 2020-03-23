package com.wenky.设计模式.桥接模式.datebase;

/**
 * @program: design-patterns
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-08-09 18:40
 */
public class Oracle extends Database {
  @Override
  public void conversion() {
    conver.doConver();
    System.out.println("Oracle数据库");
  }
}
