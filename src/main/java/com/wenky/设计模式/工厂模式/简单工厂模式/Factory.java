package com.wenky.设计模式.工厂模式.简单工厂模式;

/**
 * @program: design-patterns
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-08-09 17:14
 */
public class Factory implements Cloneable {
  public BMW createBMW(int type) {
    switch (type) {
      case 320:
        return new BMW320();
      case 523:
        return new BMW523();
      default:
        break;
    }
    return null;
  }
}
