package com.wenky.设计模式.单例模式.饿汉模式;

/**
 * @program: design-patterns
 * @description: 单例模式就是说系统中对于某个类只会有一个对象，不可能出来第二个
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2018-11-23 13:58
 */
public class UnlockSingleton {
  /** 缺点: 类加载的时候就会直接new出一个静态对象,当系统中这样的类较多会使启动速度变慢 */
  private static UnlockSingleton sin = new UnlockSingleton();

  // private类型的无参构造方法保证其他类的对象不能直接new出该对象的一个实例
  private UnlockSingleton() {}

  // 保证每次拿到的都是同一个对象实例
  public static UnlockSingleton getSin() {
    return sin;
  }
}
