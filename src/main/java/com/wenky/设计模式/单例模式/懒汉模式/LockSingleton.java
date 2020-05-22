package com.wenky.设计模式.单例模式.懒汉模式;

/**
 * @program: design-patterns
 * @description: 使用同步方法
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2018-11-23 14:10
 **/
public class LockSingleton {
    /**
     * 缺陷:
     * 每次调用方法的时候都会把对象给锁住
     * <p>
     * 一次锁住了一个方法,只要像TwoLock一样改进只锁住其中的new语句就行了
     */
    private static LockSingleton instance;

    private LockSingleton() {

    }

    public static synchronized LockSingleton getInstance() {
        if (instance == null)
            instance = new LockSingleton();
        return instance;
    }
}
