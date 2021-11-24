package com.wenky.设计模式.单例模式.懒汉模式;

/**
 * @program: design-patterns
 * @description: 双重同步锁
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2018-11-23 14:27
 */
public class TwoLockSingleton {
  private static volatile TwoLockSingleton instance;

  private TwoLockSingleton() {}

  /**
   * 只有第一次初始化对象的时候才会创建锁，锁住类对象，之后每一次调用返回同一个方法
   *
   * @return
   */
  public static TwoLockSingleton getInstance() {
    if (instance == null) {
      synchronized (TwoLockSingleton.class) {
        if (instance == null) instance = new TwoLockSingleton();
      }
    }
    return instance;
  }

  /**
   * 进阶: instance = new TwoLockSingleton() 是非原子性操作 1. 给instance分配内存 2. 调用TwoLockSingleton构造方法完成初始化操作
   * 3.使instance对象的引用指向分配的内存空间(完成这一步instance才不是null)
   *
   * <p>原因: JVM会对指令进行重排序优化，可能3在2之前执行了，3执行完之后instance就不是null了 如此时另外一个线程访问该方法就会直接返回 instance
   *
   * <p>解决方法: jdk 1.5之后才会有效 将instance变量声明为 volatile
   */
}
