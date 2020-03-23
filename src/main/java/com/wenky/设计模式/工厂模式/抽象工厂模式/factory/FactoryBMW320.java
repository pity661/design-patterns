package com.wenky.设计模式.工厂模式.抽象工厂模式.factory;

import com.wenky.设计模式.工厂模式.抽象工厂模式.product.Aircondition;
import com.wenky.设计模式.工厂模式.抽象工厂模式.product.AirconditionA;
import com.wenky.设计模式.工厂模式.抽象工厂模式.product.Engine;
import com.wenky.设计模式.工厂模式.抽象工厂模式.product.EngineA;

/**
 * @program: design-patterns
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-08-09 17:34
 */
public class FactoryBMW320 implements AbstractFactory {
  @Override
  public Engine createEngine() {
    return new EngineA();
  }

  @Override
  public Aircondition createAircondition() {
    return new AirconditionA();
  }
}
