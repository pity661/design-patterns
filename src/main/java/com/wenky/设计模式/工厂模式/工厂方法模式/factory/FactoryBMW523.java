package com.wenky.设计模式.工厂模式.工厂方法模式.factory;

import com.wenky.设计模式.工厂模式.工厂方法模式.car.BMW523;

/**
 * @program: design-patterns
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-08-09 17:23
 */
public class FactoryBMW523 implements FactoryBMW {
    @Override
    public BMW523 createBMW() {
        return new BMW523();
    }
}
