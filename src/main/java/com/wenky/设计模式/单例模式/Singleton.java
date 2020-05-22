package com.wenky.设计模式.单例模式;

/**
 * @program: design-patterns
 * @description: 使用静态内部类，最优处理方式
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-05-28 11:43
 **/
public class Singleton {

    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    private Singleton() {
    }

    public static final Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
