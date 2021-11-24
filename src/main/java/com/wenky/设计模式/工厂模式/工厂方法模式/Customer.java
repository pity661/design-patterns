package com.wenky.设计模式.工厂模式.工厂方法模式;

import com.wenky.设计模式.工厂模式.工厂方法模式.car.BMW320;
import com.wenky.设计模式.工厂模式.工厂方法模式.car.BMW523;
import com.wenky.设计模式.工厂模式.工厂方法模式.factory.FactoryBMW320;
import com.wenky.设计模式.工厂模式.工厂方法模式.factory.FactoryBMW523;

/**
 * @program: design-patterns
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-08-09 17:23
 */
public class Customer {
  public static void main(String[] args) {
    //
    FactoryBMW320 factoryBMW320 = new FactoryBMW320();
    BMW320 bmw320 = factoryBMW320.createBMW();

    FactoryBMW523 factoryBMW523 = new FactoryBMW523();
    BMW523 bmw523 = factoryBMW523.createBMW();
  }
}
