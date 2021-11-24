package com.wenky.多线程.线程安全;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @program: design-patterns
 * @description: 回环栅栏 用来挂起当前线程，直至所有线程都到达barrier状态再同时执行后续任务 public int await() throws
 *     InterruptedException, BrokenBarrierException { };
 *     让这些线程等待至一定的时间，如果还有线程没有到达barrier状态就直接让到达barrier的线程执行后续任务 public int await(long timeout,
 *     TimeUnit unit) throws InterruptedException,BrokenBarrierException,TimeoutException { };
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2018-10-29 14:48
 */

/**
 * 构造器 参数parties指让多少个线程或者任务等待至barrier状态；参数barrierAction为当这些线程都达到barrier状态时会执行的内容 public
 * CyclicBarrier(int parties, Runnable barrierAction) { } public CyclicBarrier(int parties) { }
 */
public class CyclicBarrierTest {
  public static void main(String[] args) {
    // CyclicBarrier是可重用的
    final int N = 4;
    CyclicBarrier barrier = new CyclicBarrier(N);

    for (int i = 0; i < N; i++) {
      new Writer(barrier).start();
    }

    try {
      Thread.sleep(25000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println("CyclicBarrier重用");

    for (int i = 0; i < N; i++) {
      new Writer(barrier).start();
    }
  }

  static class Writer extends Thread {
    private CyclicBarrier cyclicBarrier;

    public Writer(CyclicBarrier cyclicBarrier) {
      this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
      System.out.println("线程" + Thread.currentThread().getName() + "正在写入数据...");
      try {
        Thread.sleep(5000); // 以睡眠来模拟写入数据操作
        System.out.println("线程" + Thread.currentThread().getName() + "写入数据完毕，等待其他线程写入完毕");
        // cyclicBarrier.await(100L,TimeUnit.SECONDS);  // 如果100s还没响应继续往下执行
        cyclicBarrier.await();
      } catch (InterruptedException e) {
        e.printStackTrace();
      } catch (BrokenBarrierException e) {
        e.printStackTrace();
      }
      System.out.println(Thread.currentThread().getName() + "所有线程写入完毕，继续处理其他任务...");
    }
  }
}
