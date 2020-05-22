package com.wenky.设计模式.工厂模式.简单工厂模式;

/**
 * @program: design-patterns
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-08-09 17:16
 */
public class Customer {
    public static void main(String[] args) {
        //
        Factory factory = new Factory();
        BMW bmw320 = factory.createBMW(320);
        BMW bmw523 = factory.createBMW(523);
    }
}
