package com.wenky.设计模式.工厂模式.抽象工厂模式.factory;

import com.wenky.设计模式.工厂模式.抽象工厂模式.product.Aircondition;
import com.wenky.设计模式.工厂模式.抽象工厂模式.product.Engine;

/**
 * @program: design-patterns
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-08-09 17:34
 */
public interface AbstractFactory {
  public Engine createEngine();

  public Aircondition createAircondition();
}
