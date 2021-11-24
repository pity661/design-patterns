package com.wenky.设计模式.单例模式.synchronized锁;

/**
 * @program: design-patterns
 * @description: 创建了10个线程，锁加在类对象上，保证同一时间只有一个实例对象能拿到锁进行操作
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-05-28 11:12
 */
public class SynchronizedDemo implements Runnable {

  private static int count = 0;

  private static synchronized void addCount() {
    for (int i = 0; i < 10; i++) {
      System.out.println(count);
      System.out.println(Thread.currentThread().getName());
      count++;
    }
  }

  public static void main(String[] args) {
    for (int i = 0; i < 10; i++) {
      Thread thread = new Thread(new SynchronizedDemo());
      thread.start();
    }
    try {
      Thread.sleep(500);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("result: " + count);
  }

  @Override
  public void run() {
    /** 1.通过代码块 */
    //        synchronized (SynchronizedDemo.class) {
    //            for (int i = 0; i < 10; i++) {
    //                System.out.println(count);
    //                System.out.println(Thread.currentThread().getName());
    //                count++;
    //            }
    //        }
    /** 2.通过静态方法 */
    addCount();
  }
}
