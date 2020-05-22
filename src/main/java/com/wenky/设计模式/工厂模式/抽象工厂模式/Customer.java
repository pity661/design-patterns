package com.wenky.设计模式.工厂模式.抽象工厂模式;

import com.wenky.设计模式.工厂模式.抽象工厂模式.factory.AbstractFactory;
import com.wenky.设计模式.工厂模式.抽象工厂模式.factory.FactoryBMW320;
import com.wenky.设计模式.工厂模式.抽象工厂模式.factory.FactoryBMW523;

/**
 * @program: design-patterns
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-08-09 17:37
 */
public class Customer {
    public static void main(String[] args) {
        //
        // 生产宝马320系列配件
        AbstractFactory factoryBMW320 = new FactoryBMW320();
        factoryBMW320.createEngine();
        factoryBMW320.createAircondition();

        // 生产宝马523系列配件
        AbstractFactory factoryBMW523 = new FactoryBMW523();
        factoryBMW523.createEngine();
        factoryBMW523.createAircondition();
    }
}
