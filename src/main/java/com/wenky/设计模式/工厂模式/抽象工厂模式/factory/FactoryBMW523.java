package com.wenky.设计模式.工厂模式.抽象工厂模式.factory;

import com.wenky.设计模式.工厂模式.抽象工厂模式.product.Aircondition;
import com.wenky.设计模式.工厂模式.抽象工厂模式.product.AirconditionB;
import com.wenky.设计模式.工厂模式.抽象工厂模式.product.Engine;
import com.wenky.设计模式.工厂模式.抽象工厂模式.product.EngineB;

/**
 * @program: design-patterns
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-08-09 17:37
 */
public class FactoryBMW523 implements AbstractFactory {

    @Override
    public Engine createEngine() {
        return new EngineB();
    }

    @Override
    public Aircondition createAircondition() {
        return new AirconditionB();
    }
}
