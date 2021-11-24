package com.wenky.多线程.获取执行结果;

import java.util.concurrent.*;

/**
 * @program: design-patterns
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-07-12 10:37
 */
public class CallableFutureTaskTest {
  public static void main(String[] args) {
    // 第一种方式
    ExecutorService executorService = Executors.newCachedThreadPool();
    Task task = new Task();
    FutureTask<Integer> futureTask = new FutureTask<>(task);

    // <T> Future<T> submit(Callable<T> task);
    // 调用future.get() 返回子线程正常执行的最总结果
    Future<Integer> result = executorService.submit(task);

    // Future<?> submit(Runnable task);
    // 调用future.get()无结果返回,返回null
    Future future = executorService.submit(futureTask);

    // <T> Future<T> submit(Runnable task, T result);
    // 调用future.get()将传入的argument作为结果返回
    Future future1 = executorService.submit(futureTask, 1);
    executorService.shutdown();

    // 第二种方式，注意这种方式和第一种方式效果是类似的，只不过一个使用的是ExecutorService，一个使用的是Thread
    /*Task task = new Task();
    FutureTask<Integer> futureTask = new FutureTask<Integer>(task);
    Thread thread = new Thread(futureTask);
    thread.start();*/

    try {
      Thread.sleep(1000);
    } catch (InterruptedException e1) {
      e1.printStackTrace();
    }

    System.out.println("主线程在执行任务");

    try {
      // 都会阻塞主线程直到任务完成
      System.out.println("task运行结果 -> " + futureTask.get());
      System.out.println("task运行结果1 -> " + result.get());
      System.out.println("task运行结果2 -> " + future.get());
      System.out.println("task运行结果3 -> " + future1.get());
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (ExecutionException e) {
      e.printStackTrace();
    }
    System.out.println("所有任务执行完毕");
  }

  static class Task implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
      System.out.println("子线程在进行计算");
      Thread.sleep(3000);
      int sum = 0;
      for (int i = 0; i < 100; i++) sum += i;
      return sum;
    }
  }
}
