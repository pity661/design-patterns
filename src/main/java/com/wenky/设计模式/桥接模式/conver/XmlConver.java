package com.wenky.设计模式.桥接模式.conver;

/**
 * @program: design-patterns
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-08-09 19:04
 */
public class XmlConver implements Conver {
  @Override
  public void doConver() {
    System.out.println("转化为xml格式，数据库为:");
  }
}
