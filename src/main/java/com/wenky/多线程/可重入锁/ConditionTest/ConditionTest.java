package com.wenky.多线程.可重入锁.ConditionTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: design-patterns
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-07-22 16:04
 */
public class ConditionTest {
  public static void main(String[] args) throws InterruptedException {
    //
    ExecutorService service = Executors.newCachedThreadPool();

    // 1.在主线程执行循环
    //    Task task = new Task();
    //    while (true) {
    //      service.execute(new Task.AddThread(task));
    //      service.execute(new Task.SubThread(task));
    //    }
    // 2.在当个线程中执行循环
    TaskLoop task = new TaskLoop();
    service.execute(new TaskLoop.AddThread(task));
    service.execute(new TaskLoop.SubThread(task));
    System.out.println("主线程结束了");
  }
}
