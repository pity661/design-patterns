package com.wenky.设计模式.工厂模式.工厂方法模式.factory;

import com.wenky.设计模式.工厂模式.工厂方法模式.car.BMW320;

/**
 * @program: design-patterns
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-08-09 17:20
 */
public class FactoryBMW320 implements FactoryBMW {
  @Override
  public BMW320 createBMW() {
    return new BMW320();
  }
}
